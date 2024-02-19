package by.sportliner.lk.core.service.telegram;


import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.ClassSchedule;
import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.repository.TelegramChatRepository;
import by.sportliner.lk.core.service.BranchOfficeService;
import by.sportliner.lk.core.service.email.EmailService;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static by.sportliner.lk.core.service.telegram.UserState.*;


public class ResponseHandler {

    private static final String CHAT_STATES = "chatStates";

    private static final String START_TEXT = "Приветствуем Вас в виртуальном помощнике Sportliner. " +
        "\nВыберите ниже команду и я Вам помогу.";

    private final SilentSender sender;
    private final Map<Long, UserState> chatStates;

    private BranchOfficeService branchOfficeService;
    private TelegramChatRepository telegramChatRepository;
    private EmailService emailService;

    public ResponseHandler(SilentSender sender, DBContext db,
                           BranchOfficeService branchOfficeService, TelegramChatRepository telegramChatRepository,
                           EmailService emailService) {
        this.sender = sender;
        this.branchOfficeService = branchOfficeService;
        this.telegramChatRepository = telegramChatRepository;
        this.emailService = emailService;

        chatStates = new HashMap<>();
    }

    public boolean userIsActive(Long chatId) {
        return chatStates.containsKey(chatId);
    }

    public void replyToStart(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(START_TEXT);
        message.setReplyMarkup(KeyboardFactory.getSupportedOperations());
        sender.execute(message);
        chatStates.put(chatId, AWAITING_OPERATION_SELECTION);
    }

    public void replyToButtons(long chatId, Message message) {
        if (message.getText().equalsIgnoreCase("/stop")) {
            stopChat(chatId, message);
        }

        switch (chatStates.get(chatId)) {
            case AWAITING_OPERATION_SELECTION -> operationSelection(chatId, message);
            case AWAITING_BRANCH_OFFICE -> addBranchOffice(chatId, message);
            case AWAITING_PHONE -> addPhone(chatId, message);
            default -> unexpectedMessage(chatId);
        }
    }

    private void stopChat(long chatId, Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Благодарим Вас за заявку на пробное занятие!\nНажмите /start для возобновления диалога.");
        chatStates.remove(chatId);
        sendMessage.setReplyMarkup(new ReplyKeyboardRemove(true));
        sender.execute(sendMessage);
    }

    @Transactional
    public void operationSelection(long chatId, Message message) {
        if (message.getText().equalsIgnoreCase("Записаться на пробное занятие")) {
            Optional<TelegramChat> oldChat =
                telegramChatRepository.findByChatIdAndUsernameAndPhone(chatId, message.getChat().getUserName(), null);

            if (oldChat.isPresent()) {
                telegramChatRepository.delete(oldChat.get());
            }


            TelegramChat telegramChat = new TelegramChat();

            telegramChat.setChatId(message.getChatId());
            telegramChat.setUsername(message.getChat().getUserName());
            telegramChat.setCreateTimestamp(Instant.now());

            telegramChatRepository.save(telegramChat);

            SendMessage responseMessage = new SendMessage();
            responseMessage.setChatId(chatId);
            responseMessage.setText("Пожалуйста, выберите филиал для пробного занятия");
            responseMessage.setReplyMarkup(KeyboardFactory.getSupportedBranchOffice(branchOfficeService.findAll()));
            sender.execute(responseMessage);
            chatStates.put(chatId, AWAITING_BRANCH_OFFICE);
        }
    }

    private void addBranchOffice(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());
        BranchOffice branchOffice = branchOfficeService.getByName(message.getText());
        telegramChat.setBranchOffice(branchOffice);

        telegramChatRepository.save(telegramChat);

        String messageText = "Расписание занятий на филиале: \n";

        for (DayOfWeek day : DayOfWeek.values()) {
            Function<DayOfWeek, String> renderDayOfWeek = (dayOfWeek) -> switch (dayOfWeek) {
                case MONDAY -> "Понедельник";
                case TUESDAY -> "Вторник";
                case WEDNESDAY -> "Среда";
                case THURSDAY -> "Четверг";
                case FRIDAY -> "Пятница";
                case SATURDAY -> "Суббота";
                case SUNDAY -> "Воскресенье";
            };

            Function<List<ClassSchedule>, String> renderSchedules = (schedules) -> schedules.stream()
                .map(ClassSchedule::getTime)
                .map(LocalTime::toString)
                .collect(Collectors.joining(", "));

            List<ClassSchedule> schedules = branchOffice.getClassSchedules().stream()
                .filter(it -> it.getDay().equals(day))
                .collect(Collectors.toList());

            if (schedules.isEmpty()) {
                continue;
            }

            String scheduleForDay = "${day}: ${schedules}"
                .replace("${day}", renderDayOfWeek.apply(day))
                .replace("${schedules}", renderSchedules.apply(schedules));

            messageText = messageText + "\n" + scheduleForDay;
        }

        messageText = messageText + "\n\n Пожалуйста, введите Ваш контактный телефон";

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);

        responseMessage.setText(messageText);
        responseMessage.setReplyMarkup(KeyboardFactory.renderCancelButton());
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_PHONE);
    }

    private void addPhone(long chatId, Message message) {
        String messageText = message.getText();

        if (messageText.equals("Вернуться к списку филиалов")) {
            SendMessage responseMessage = new SendMessage();
            responseMessage.setChatId(chatId);
            responseMessage.setText("Пожалуйста, выберите филиал для пробного занятия");
            responseMessage.setReplyMarkup(KeyboardFactory.getSupportedBranchOffice(branchOfficeService.findAll()));
            sender.execute(responseMessage);
            chatStates.put(chatId, AWAITING_BRANCH_OFFICE);

            return;
        }

        Matcher matcher = Pattern.compile("^\\+375 \\((17|29|33|44|25)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$")
            .matcher(messageText);

        if (!matcher.matches()) {
            SendMessage responseMessage = new SendMessage();

            responseMessage.setChatId(chatId);
            responseMessage.setText("Пожалуйста, введите телефон в формате +375 (29) 123-45-67");

            sender.execute(responseMessage);

            chatStates.put(chatId, AWAITING_PHONE);

            return;
        }

        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());

        telegramChat.setPhone(messageText);

        telegramChatRepository.save(telegramChat);

        emailService.notifyAboutNewTelegramChat(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText(
            "Запись на пробное занятие зафиксирована. " +
                "\nВ ближайшее время наш администратор с Вами свяжется для уточнения деталей!"
        );
        responseMessage.setReplyMarkup(null);
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_OPERATION_SELECTION);
    }

    private void unexpectedMessage(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Неизвестная операция.");
        sender.execute(sendMessage);
    }

    private TelegramChat getTelegramChat(Long chatId, String username) {
        return telegramChatRepository.findByChatIdAndUsernameAndPhone(chatId, username, null)
            .orElseThrow(() -> new IllegalArgumentException("This chat is not registered"));
    }

}

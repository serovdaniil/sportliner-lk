package by.sportliner.lk.core.service.telegram;


import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.model.TrialAttendance;
import by.sportliner.lk.core.repository.TelegramChatRepository;
import by.sportliner.lk.core.repository.TrialAttendanceRepository;
import by.sportliner.lk.core.service.BranchOfficeService;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static by.sportliner.lk.core.service.telegram.UserState.*;


public class ResponseHandler {

    private static final String CHAT_STATES = "chatStates";

    private static final String START_TEXT = "Приветствуем Вас в виртуальном помощнике Sportliner. " +
        "\nВыберите ниже команду и я Вам помогу. " +
        "\nПродолжая работу с виртуальным помощником, Вы даете согласие на обрабтку персональных данных.";

    private final SilentSender sender;
    private final Map<Long, UserState> chatStates;

    private BranchOfficeService branchOfficeService;
    private TelegramChatRepository telegramChatRepository;
    private TrialAttendanceRepository trialAttendanceRepository;

    public ResponseHandler(SilentSender sender, DBContext db,
                           BranchOfficeService branchOfficeService, TelegramChatRepository telegramChatRepository,
                           TrialAttendanceRepository trialAttendanceRepository) {
        this.sender = sender;
        this.branchOfficeService = branchOfficeService;
        this.telegramChatRepository = telegramChatRepository;
        this.trialAttendanceRepository = trialAttendanceRepository;

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
            stopChat(chatId);
        }

        switch (chatStates.get(chatId)) {
            case AWAITING_OPERATION_SELECTION -> operationSelection(chatId, message);
            case AWAITING_CHILD_NAME -> addChildName(chatId, message);
            case AWAITING_PHONE -> addPhone(chatId, message);
            case AWAITING_DIAGNOSIS -> addDiagnosis(chatId, message);
            case AWAITING_BRANCH_OFFICE -> addBranchOffice(chatId, message);
            case AWAITING_DATE -> addDate(chatId, message);
            default -> unexpectedMessage(chatId);
        }
    }

    private void stopChat(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Thank you for your order. See you soon!\nPress /start to order again");
        chatStates.remove(chatId);
        sendMessage.setReplyMarkup(new ReplyKeyboardRemove(true));
        sender.execute(sendMessage);
    }

    @Transactional
    public void operationSelection(long chatId, Message message) {
        if (message.getText().equalsIgnoreCase("Записаться на пробное занятие")) {
            Optional<TelegramChat> oldChat =
                telegramChatRepository.findByChatIdAndUsername(chatId, message.getChat().getUserName());

            if (oldChat.isPresent()) {
                telegramChatRepository.delete(oldChat.get());
            }

            TelegramChat telegramChat = new TelegramChat();

            telegramChat.setChatId(message.getChatId());
            telegramChat.setUsername(message.getChat().getUserName());

            telegramChatRepository.save(telegramChat);

            SendMessage responseMessage = new SendMessage();
            responseMessage.setChatId(chatId);
            responseMessage.setText("Пожалуйста, введите ФИО ребенка");
            responseMessage.setReplyMarkup(null);
            sender.execute(responseMessage);
            chatStates.put(chatId, AWAITING_CHILD_NAME);
        }
    }

    private void addChildName(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());

        telegramChat.setChildFio(message.getText());

        telegramChatRepository.save(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText("Пожалуйста, введите Ваш контактный телефон");
        responseMessage.setReplyMarkup(null);
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_PHONE);

    }

    private void addPhone(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());

        telegramChat.setPhone(message.getText());

        telegramChatRepository.save(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText("Пожалуйста, введите диагноз ребенка");
        responseMessage.setReplyMarkup(null);
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_DIAGNOSIS);

    }

    private void addDiagnosis(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());

        telegramChat.setDiagnosis(message.getText());

        telegramChatRepository.save(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText("Пожалуйста, выберите филиал для пробного занятия");
        responseMessage.setReplyMarkup(KeyboardFactory.getSupportedBranchOffice(branchOfficeService.findAll()));
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_BRANCH_OFFICE);

    }

    private void addBranchOffice(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());
        BranchOffice branchOffice = branchOfficeService.getByName(message.getText());
        telegramChat.setBranchOffice(branchOffice);

        telegramChatRepository.save(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText("Пожалуйста, выберите дату пробного занятия");
        responseMessage.setReplyMarkup(KeyboardFactory.renderDates(branchOfficeService.getClassSchedules(branchOffice, YearMonth.now()).keySet()));
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_DATE);

    }

    private void addDate(long chatId, Message message) {
        TelegramChat telegramChat = getTelegramChat(chatId, message.getChat().getUserName());

        telegramChat.setDate(LocalDate.parse(message.getText()));

        telegramChatRepository.save(telegramChat);

        TrialAttendance trialAttendance = new TrialAttendance();

        trialAttendance.setBranchOffice(telegramChat.getBranchOffice());
        trialAttendance.setName(telegramChat.getChildFio());
        trialAttendance.setTrialAttendanceStatus(TrialAttendance.TrialAttendanceStatus.UNATTENDED);
        trialAttendance.setPhone(telegramChat.getPhone());
        trialAttendance.setDiagnosis(telegramChat.getDiagnosis());
        trialAttendance.setDate(telegramChat.getDate());
        trialAttendance.setTelegramUsername(telegramChat.getUsername());

        trialAttendanceRepository.save(trialAttendance);
        telegramChatRepository.delete(telegramChat);

        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText("Запись на пробное занятие зафиксирована. \n Ждём Вас на занятие!");
        responseMessage.setReplyMarkup(null);
        sender.execute(responseMessage);
        chatStates.put(chatId, AWAITING_BRANCH_OFFICE);

    }

    private void unexpectedMessage(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("I did not expect that.");
        sender.execute(sendMessage);
    }

    private TelegramChat getTelegramChat(Long chatId, String username) {
        return telegramChatRepository.findByChatIdAndUsername(chatId, username)
            .orElseThrow(() -> new IllegalArgumentException("This chat is not registered"));
    }

}

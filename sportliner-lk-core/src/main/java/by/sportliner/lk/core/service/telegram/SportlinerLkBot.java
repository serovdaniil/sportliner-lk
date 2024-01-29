package by.sportliner.lk.core.service.telegram;

import by.sportliner.lk.core.repository.TelegramChatRepository;
import by.sportliner.lk.core.repository.TrialAttendanceRepository;
import by.sportliner.lk.core.service.BranchOfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.BiConsumer;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;
import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

@Slf4j
@Component(value = "sportlinerLkBot")
public class SportlinerLkBot extends AbilityBot {

    private static final String START_DESCRIPTION = "Запуск виртуального помощника";

    private final ResponseHandler responseHandler;

    public SportlinerLkBot(@Value("${sportliner.lk.bot.token}") String token,
                           @Value("${sportliner.lk.bot.username}") String username,
                           @Autowired BranchOfficeService branchOfficeService,
                           @Autowired TelegramChatRepository telegramChatRepository,
                           @Autowired TrialAttendanceRepository trialAttendanceRepository) {
        super(token, username);

        responseHandler = new ResponseHandler(
            silent, db, branchOfficeService, telegramChatRepository, trialAttendanceRepository
        );
    }

    @Override
    public long creatorId() {
        return 1L;
    }

    public Ability startBot() {
        return Ability
            .builder()
            .name("start")
            .info(START_DESCRIPTION)
            .locality(USER)
            .privacy(PUBLIC)
            .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
            .build();
    }

    public Reply replyToButtons() {
        BiConsumer<BaseAbilityBot, Update> action = (abilityBot, upd) -> responseHandler.replyToButtons(getChatId(upd), upd.getMessage());
        return Reply.of(action, Flag.TEXT, upd -> responseHandler.userIsActive(getChatId(upd)));
    }
}

package by.sportliner.lk.endpoint;

import by.sportliner.lk.core.SportlinerLkCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@Import(SportlinerLkCoreConfiguration.class)
public class EndpointApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(EndpointApplication.class, args);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(ctx.getBean("sportlinerLkBot", AbilityBot.class));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}

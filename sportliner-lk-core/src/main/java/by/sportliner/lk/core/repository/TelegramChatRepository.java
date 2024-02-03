package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.TelegramChat;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link TelegramChat}.
 */
@Repository
public interface TelegramChatRepository extends JpaRepositoryImplementation<TelegramChat, String> {

    Optional<TelegramChat> findByChatIdAndUsernameAndPhone(Long chatId, String username, String phone);

}

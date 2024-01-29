package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.Attendance;
import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.TelegramChat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link TelegramChat}.
 */
@Repository
public interface TelegramChatRepository extends JpaRepositoryImplementation<TelegramChat, String> {

    Optional<TelegramChat> findByChatIdAndUsername(Long chatId, String username);

}

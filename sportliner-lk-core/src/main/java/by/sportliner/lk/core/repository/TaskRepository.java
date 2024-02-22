package by.sportliner.lk.core.repository;

import by.sportliner.lk.core.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link by.sportliner.lk.core.model.Task}.
 */
@Repository
public interface TaskRepository extends JpaRepositoryImplementation<Task, String> {

    @Modifying
    @Query("update Task u set u.status = :status where u.id = :id")
    void updateStatus(@Param(value = "id") String id, @Param(value = "status") Task.TaskStatus status);

}

package com.sbaldasso.todo_list.repositories;

import com.sbaldasso.todo_list.models.Task;
import com.sbaldasso.todo_list.models.TaskStatus;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);

    List<Task> findByEndDateBefore(LocalDateTime endDate);

    List<Task> findByEndDateAfter(LocalDateTime endDate);
}

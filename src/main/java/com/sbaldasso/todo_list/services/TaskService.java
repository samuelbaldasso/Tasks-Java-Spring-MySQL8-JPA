package com.sbaldasso.todo_list.services;

import com.sbaldasso.todo_list.dtos.TaskDTO;
import com.sbaldasso.todo_list.models.Task;
import com.sbaldasso.todo_list.models.TaskStatus;
import com.sbaldasso.todo_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setCreatedAt(LocalDateTime.now());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setDescription(taskDTO.getDescription());

        return taskRepository.save(task);
    }

    public Task update(TaskDTO taskDTO, Long id) {
        Task task = getById(id);
        task.setTitle(taskDTO.getTitle());
        task.setUpdatedAt(LocalDateTime.now());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setDescription(taskDTO.getDescription());

        return taskRepository.save(task);
    }

    public List<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByTaskStatus(status);
    }

    public List<Task> findByEndDateDueBefore(LocalDateTime endDate) {
        return taskRepository.findByEndDateBefore(endDate);
    }

    public List<Task> findByEndDateDueAfter(LocalDateTime endDate) {
        return taskRepository.findByEndDateAfter(endDate);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}

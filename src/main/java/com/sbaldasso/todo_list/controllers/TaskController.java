package com.sbaldasso.todo_list.controllers;

import com.sbaldasso.todo_list.dtos.TaskDTO;
import com.sbaldasso.todo_list.models.Task;
import com.sbaldasso.todo_list.models.TaskStatus;
import com.sbaldasso.todo_list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.create(taskDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDTO taskDTO, @PathVariable Long id) {
        return ResponseEntity.ok(taskService.update(taskDTO, id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam TaskStatus status) {
        List<Task> tasks = taskService.findByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/endDateBefore")
    public ResponseEntity<List<Task>> getByEndDateBefore(@RequestParam String endDate) {
        LocalDateTime localDateTime = LocalDateTime.parse(endDate);
        return ResponseEntity.ok(taskService.findByEndDateDueBefore(localDateTime));
    }

    @GetMapping("/endDateAfter")
    public ResponseEntity<List<Task>> getByEndDateAfter(@RequestParam String endDate) {
        LocalDateTime localDateTime = LocalDateTime.parse(endDate);
        return ResponseEntity.ok(taskService.findByEndDateDueAfter(localDateTime));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

}

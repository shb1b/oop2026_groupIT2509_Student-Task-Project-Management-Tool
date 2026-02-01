package services;

import entities.Task;
import repositories.TaskRepository;
import exceptions.DeadlineInPastException;
import exceptions.TaskWithoutProjectException;
import exceptions.InvalidStatusTransitionException;
import services.TaskFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(int id, String title, String status, LocalDate deadline, int projectId) {

        if (projectId <= 0) {
            throw new TaskWithoutProjectException("Task must belong to a project");
        }

        if (deadline.isBefore(LocalDate.now())) {
            throw new DeadlineInPastException("Deadline cannot be in the past");
        }

        Task task = new Task(id, title, status, deadline, projectId);
        taskRepository.addTask(task);
    }

    public void changeStatus(Task task, String newStatus) {

        if (task.getStatus().equals("DONE")) {
            throw new InvalidStatusTransitionException("Cannot change status from DONE");
        }

        task.setStatus(newStatus);
    }

    public void showTasks() {
        for (Task task : taskRepository.getAllTasks()) {
            System.out.println(
                    "Task: " + task.getTitle() + ", status: " + task.getStatus()
            );
        }
    }

    public List<Task> findTasksByStatus(String status) {
        return taskRepository.getAllTasks()
                .stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public void createUrgentTask(int id, String title, int projectId) {
        Task task = TaskFactory.createTask("URGENT", id, title, projectId);
        taskRepository.addTask(task);
    }
}

package repositories;

import entities.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Repository<Task> {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void add(Task task) {
        addTask(task);
    }

    @Override
    public List<Task> getAll() {
        return getAllTasks();
    }
}

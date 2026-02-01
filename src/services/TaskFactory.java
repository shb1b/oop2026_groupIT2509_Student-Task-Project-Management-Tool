package services;

import entities.Task;
import java.time.LocalDate;

public class TaskFactory {

    public static Task createTask(String type, int id, String title, int projectId) {

        if (type.equals("URGENT")) {
            return new Task(id, title, "IN_PROGRESS", LocalDate.now().plusDays(1), projectId);
        }

        if (type.equals("REGULAR")) {
            return new Task(id, title, "NEW", LocalDate.now().plusDays(7), projectId);
        }

        throw new IllegalArgumentException("Unknown task type");
    }
}

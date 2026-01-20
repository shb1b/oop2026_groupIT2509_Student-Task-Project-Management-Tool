import entities.User;
import entities.Project;
import entities.Task;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        User user = new User(1, "baizhana", "baizhana@mail.com");
        Project project = new Project(1, "OOP Assignment", user.getId());
        Task task = new Task(
                1,
                "Implement entities",
                "TODO",
                LocalDate.now().plusDays(3),
                project.getId()
        );

        System.out.println("USER CREATED: " + user.getName());
        System.out.println("PROJECT CREATED: " + project.getName());
        System.out.println("TASK CREATED: " + task.getTitle());
        System.out.println("TASK STATUS: " + task.getStatus());
    }
}

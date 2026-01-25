import entities.*;
import repositories.*;
import services.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Repositories
        UserRepository userRepository = new UserRepository();
        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();
        CommentRepository commentRepository = new CommentRepository();

        // Services
        UserService userService = new UserService(userRepository);
        ProjectService projectService = new ProjectService(projectRepository);
        TaskService taskService = new TaskService(taskRepository);
        CommentService commentService = new CommentService(commentRepository);

        // Create User
        User user = new User(1, " Baizhana", "baizhana@mail.com");
        userService.addUser(user);

        // Create Project
        Project project = new Project(1, "Project management tool", user.getId());
        projectService.createProject(project);

        // Create Task
        taskService.createTask(
                1,
                "Finish Milestone 1",
                "TODO",
                LocalDate.now().plusDays(2),
                project.getId()
        );

        // Change Task Status
        Task task = taskRepository.getAllTasks().get(0);
        taskService.changeStatus(task, "IN_PROGRESS");

        // Add Comment
        Comment comment = new Comment(1, "Project structure is ready", 1);
        commentService.addComment(comment);

        // OUTPUT
        System.out.println("USERS");
        userService.showUsers();

        System.out.println("\n PROJECTS");
        projectService.showProjects();

        System.out.println("\n TASKS");
        taskService.showTasks();

        System.out.println("\n COMMENTS");
        System.out.println("Total comments: " + commentRepository.getAllComments().size());
    }
}

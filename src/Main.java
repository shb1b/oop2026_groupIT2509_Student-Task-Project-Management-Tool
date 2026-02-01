import entities.*;
import repositories.*;
import services.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();
        CommentRepository commentRepository = new CommentRepository();

        UserService userService = new UserService(userRepository);
        ProjectService projectService = new ProjectService(projectRepository);
        TaskService taskService = new TaskService(taskRepository);
        CommentService commentService = new CommentService(commentRepository);

        User user = new User(1, "Baizhana", "baizhana@mail.com");
        userService.addUser(user);

        Project project = new Project(1, "Project management tool", user.getId());
        projectService.createProject(project);

        taskService.createTask(
                1,
                "Finish Milestone 2",
                "TODO",
                LocalDate.now().plusDays(2),
                project.getId()
        );

        taskService.createUrgentTask(
                2,
                "Fix urgent bug",
                project.getId()
        );

        Task taskFromBuilder = new TaskBuilder()
                .setId(3)
                .setTitle("Prepare defense")
                .setStatus("NEW")
                .setDeadline(LocalDate.now().plusDays(5))
                .setProjectId(project.getId())
                .build();

        taskRepository.add(taskFromBuilder);

        Task task = taskRepository.getAllTasks().get(0);
        taskService.changeStatus(task, "IN_PROGRESS");

        Comment comment = new Comment(1, "Project structure is ready", task.getId());
        commentService.addComment(comment);

        System.out.println("\nTASKS WITH STATUS 'NEW':");
        List<Task> newTasks = taskService.findTasksByStatus("NEW");
        newTasks.forEach(t -> System.out.println("- " + t.getTitle()));

        System.out.println("\nUSERS");
        userService.showUsers();

        System.out.println("\nPROJECTS");
        projectService.showProjects();

        System.out.println("\nALL TASKS");
        taskService.showTasks();

        System.out.println("\nCOMMENTS");
        System.out.println("Total comments: " + commentRepository.getAllComments().size());

        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("\nCONFIGURATION MANAGER INSTANCE: " + config);
    }
}

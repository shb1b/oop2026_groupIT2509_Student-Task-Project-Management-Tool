package services;

import entities.Project;
import repositories.ProjectRepository;

public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(Project project) {
        projectRepository.addProject(project);
    }

    public void showProjects() {
        for (Project project : projectRepository.getAllProjects()) {
            System.out.println(
                    "Project: " + project.getName() + ", ownerId: " + project.getOwnerId()
            );
        }
    }
}

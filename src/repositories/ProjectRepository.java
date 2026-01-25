package repositories;

import entities.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getAllProjects() {
        return projects;
    }
}

package entities;

import java.time.LocalDate;

public class TaskBuilder {

    private int id;
    private String title;
    private String status;
    private LocalDate deadline;
    private int projectId;

    public TaskBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public TaskBuilder setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public TaskBuilder setProjectId(int projectId) {
        this.projectId = projectId;
        return this;
    }

    public Task build() {
        return new Task(id, title, status, deadline, projectId);
    }
}
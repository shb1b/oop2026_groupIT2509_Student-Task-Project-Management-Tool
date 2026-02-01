package entities;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String status;
    private LocalDate deadline;
    private int projectId;

    public Task(int id, String title, String status, LocalDate deadline, int projectId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.deadline = deadline;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getProjectId() {
        return projectId;
    }
}
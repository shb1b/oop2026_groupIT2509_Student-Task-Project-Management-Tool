package entities;

public class Comment {
    private int id;
    private String text;
    private int taskId;

    public Comment(int id, String text, int taskId) {
        this.id = id;
        this.text = text;
        this.taskId = taskId;
    }
}

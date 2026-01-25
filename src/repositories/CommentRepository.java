package repositories;

import entities.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {

    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getAllComments() {
        return comments;
    }
}

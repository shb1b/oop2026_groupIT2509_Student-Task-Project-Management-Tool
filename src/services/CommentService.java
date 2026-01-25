package services;

import entities.Comment;
import repositories.CommentRepository;

public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }
}

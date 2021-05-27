package com.social.network.icapture.service;

import com.social.network.icapture.model.Comment;
import com.social.network.icapture.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public long addComment(Comment comment) {
        Comment newComment = commentRepository.insertUser(comment);
        return newComment.getCommentId();
    }
}

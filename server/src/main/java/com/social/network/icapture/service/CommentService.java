package com.social.network.icapture.service;

import com.social.network.icapture.model.Comment;
import com.social.network.icapture.model.Photo;
import com.social.network.icapture.repository.CommentRepository;
import com.social.network.icapture.repository.PhotoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    private Logger logger;

    public long addComment(long photoId, Comment comment) {
        Comment newComment = commentRepository.insertUser(comment);
        logger.info("logging !!!");
        logger.info(String.valueOf(newComment == null));
        logger.info(newComment.toString());
        long commentId = newComment.getCommentId();
        logger.info(String.valueOf(photoId));
        Photo photo = photoRepository.findOneById(photoId);
        photo.getComments().add(commentId);
        photoRepository.updateOnePhoto(photo);
        return commentId;
    }
}

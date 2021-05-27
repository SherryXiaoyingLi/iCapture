package com.social.network.icapture.controller;

import com.social.network.icapture.model.Comment;
import com.social.network.icapture.service.CommentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private Logger logger;

    @PostMapping("/")
    public ResponseEntity<Long> writeComment(@RequestBody Comment comment) {
        long commentId = commentService.addComment(comment);
        return new ResponseEntity<>(commentId, HttpStatus.OK);
    }

}

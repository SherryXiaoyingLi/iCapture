package com.social.network.icapture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "comment")
public class Comment {

    @Id
    @NotNull
    private long commentId;
    @NotNull
    private String content;
    @NotNull
    private long userId;

    public Comment(@NotNull long commentId, @NotNull String content, @NotNull long userId) {
        this.commentId = commentId;
        this.content = content;
        this.userId = userId;
    }

    public long getCommentId() {
        return commentId;
    }


    public String getContent() {
        return content;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return String.format("Comment(commentId=%d, content='%s', userId=%d)",
                commentId, content, userId);
    }

}

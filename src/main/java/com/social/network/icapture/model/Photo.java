package com.social.network.icapture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "photo")
public class Photo {

    @Id
    @NotNull
    private long photoId;
    @NotNull
    private LocalDateTime timePosted;
    @NotNull
    private String s3Url;
    @NotNull
    private long userId;
    private String text;
    private List<Long> likedBy;
    private List<Long> comments;


    public Photo(@NotNull long photoId, @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timePosted,
                 @NotNull String s3Url, @NotNull long userId, String text, List<Long> likedBy, List<Long> comments) {
        this.photoId = photoId;
        this.timePosted = timePosted;
        this.s3Url = s3Url;
        this.userId = userId;
        this.text = text;
        this.likedBy = likedBy;
        this.comments = comments;
    }


    public long getPhotoId() {
        return photoId;
    }

    public LocalDateTime getTimePosted() {
        return timePosted;
    }

    public String getS3Url() {
        return s3Url;
    }

    public long getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public List<Long> getLikedBy() {
        return likedBy;
    }

    public List<Long> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return String.format("Photo(photoId=%d, timePosted='%s', s3Url='%s', userId=%d, text='%s', likedBy='%s', comments='%s')",
                photoId, timePosted.toString(), s3Url, userId, text, likedBy.toString(), comments.toString());
    }

}

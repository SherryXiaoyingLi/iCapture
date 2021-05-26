package com.social.network.icapture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document(collation = "photo")
public class Photo {

    @Id
    @NotNull
    private long photoId;
    @NotNull
    private Date timePosted;
    @NotNull
    private String s3Url;
    @NotNull
    private long userId;
    private String text;
    private List<Long> likedBy;

    public Photo(@NotNull long photoId, @NotNull Date timePosted, @NotNull String s3Url,
                 @NotNull long userId, String text, List<Long> likedBy) {
        this.photoId = photoId;
        this.timePosted = timePosted;
        this.s3Url = s3Url;
        this.userId = userId;
        this.text = text;
        this.likedBy = likedBy;
    }


    public long getPhotoId() {
        return photoId;
    }

    public Date getTimePosted() {
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

    @Override
    public String toString() {
        return String.format("Photo(photoId=%d, timePosted='%s', s3Url='%s', userId=%d, text='%s', likedBy='%s')",
                photoId, timePosted.toString(), s3Url, userId, text, likedBy.toString());
    }

}

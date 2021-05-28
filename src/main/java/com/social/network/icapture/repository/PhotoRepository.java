package com.social.network.icapture.repository;

import com.social.network.icapture.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Photo insertPhoto(Photo photo) {
        return mongoTemplate.save(photo);
    }

    public Photo findOneById(long photoId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("photoId").is(photoId));
        Photo photo = mongoTemplate.findOne(query, Photo.class);
        return photo;
    }

    public List<Photo> findAll() {
        List<Photo> photoList = mongoTemplate.findAll(Photo.class);
        return photoList;
    }

    public Photo updateOnePhoto(Photo photo) {
        return mongoTemplate.save(photo);
    }

    public void deletePhoto(Photo photo) {
        mongoTemplate.remove(photo);
    }
}

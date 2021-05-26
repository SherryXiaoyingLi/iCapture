package com.social.network.icapture.repository;

import com.social.network.icapture.model.Comment;
import com.social.network.icapture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Comment insertUser(Comment comment) {
        return mongoTemplate.save(comment);
    }

    public Comment findOneById(long commentId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("commentId").is(commentId));
        Comment comment = mongoTemplate.findOne(query, Comment.class);
        return comment;
    }

    public Comment updateOneComment(Comment comment) {
        return mongoTemplate.save(comment);
    }

    public void deleteComment(Comment comment) {
        mongoTemplate.remove(comment);
    }
}

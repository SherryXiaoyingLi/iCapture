package com.social.network.icapture.repository;

import com.social.network.icapture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    /**
     * variable is injected by @Autowired from the bean initialized by Spring Boot
     * using properties defined in application.properties
     */
    @Autowired
    private MongoTemplate mongoTemplate;


    public User insertUser(User user) {
        return mongoTemplate.save(user);
    }

    public User findOneByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    public User findOneById(long userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    public User updateOneUser(User user) {
        return mongoTemplate.save(user);
    }

    public void deleteUser(User user) {
        mongoTemplate.remove(user);
    }
}

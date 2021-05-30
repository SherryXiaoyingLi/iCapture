package com.social.network.icapture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class JwtBlackListRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public JwtBlackList findOneFromStore(String token) {
        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));
        JwtBlackList jwtBlackList = mongoTemplate.findOne(query, JwtBlackList.class);
        return jwtBlackList;
    }

    public JwtBlackList saveExpired(String token) {
        return mongoTemplate.save(new JwtBlackList(token));
    }
}

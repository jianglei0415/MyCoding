package com.springboot.chapter8.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.springboot.chapter8.pojo.User;
import com.springboot.chapter8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 22:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user, "user");
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Query query = Query.query(criteriaId);
        DeleteResult result = mongoTemplate.remove(query, User.class);
        return result;
    }

    @Override
    public List<User> findUser(String userName, String note, int skip, int limit) {
        Criteria criteria = Criteria.where("userName").regex(userName).and("note").regex(note);
        Query query = Query.query(criteria).limit(limit).skip(skip);
        List<User> userList = mongoTemplate.find(query, User.class);
        return userList;
    }

    @Override
    public UpdateResult updateUser(Long id, String userName, String note) {
        Criteria criteriaId=Criteria.where("id").is(id);
        Query query = Query.query(criteriaId);
        Update update = Update.update("userName", userName);
        update.set("note",note);
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
//        UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);
        return result;
    }

    @Override
    public User getUser(Long id) {
        return mongoTemplate.findById(id, User.class);
    }
}

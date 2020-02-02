package com.springboot.chapter14.repository;

import com.springboot.chapter14.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author: jianglei
 * @date: 2020/2/2 14:29
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
    /**
     * 对用户名和备注进行模糊查询
     *
     * @param userName 用户名
     * @param note     备注
     * @return 符合条件的用户
     */
    Flux<User> findByUserNameLikeAndNoteLike(String userName, String note);
}

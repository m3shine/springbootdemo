package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by djklaf on 2017/1/9.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}

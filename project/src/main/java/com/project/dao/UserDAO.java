package com.project.dao;

import com.project.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends CrudRepository<User, Integer> {

    User save(User user);

    @Query(value = "SELECT * FROM users WHERE id=:id", nativeQuery = true)
    User findUserById(@Param("id") int id);

    @Query(value = "SELECT * FROM users WHERE email=:email and password=:password", nativeQuery = true)
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}

package com.project.dao;

import com.project.entity.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestDAO extends CrudRepository<Request, Integer> {

    List<Request> findAll();

    @Query(value = "SELECT * FROM requests WHERE id=:id", nativeQuery = true)
    Request findRequestById(@Param("id") int id);

    Request save(Request request);

    @Query(value = "SELECT * FROM requests WHERE isDone=:isDone", nativeQuery = true)
    List<Request> findRequestByDone(@Param("isDone") Boolean isDone);

    @Query(value = "SELECT * FROM requests WHERE userId=:userId", nativeQuery = true)
    List<Request> findRequestByUserId(@Param("userId") int userId);

}

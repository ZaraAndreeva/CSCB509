package com.project.service;

import com.project.dao.UserDAO;
import com.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUserById(int id) {
        return userDAO.findUserById(id);
    }

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public User login(String email, String password) {
        return userDAO.findUserByEmailAndPassword(email, password);
    }


}

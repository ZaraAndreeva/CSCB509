package com.project.controller;

import com.project.entity.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index() {
        return "signinform";
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestParam(name = "name") String name,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "role") String role,
                               @RequestParam(name = "password") String password) {

        User userToSave = new User();
        userToSave.setEmail(email);
        userToSave.setPassword(password);
        userToSave.setName(name);
        userToSave.setRole(role);
        userService.addUser(userToSave);
        return "signinform";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {

        User user = userService.login(email, password);

        if (user != null && user.getRole() != null) {
            request.getSession().setAttribute("user", user);

            request.getSession().setMaxInactiveInterval(60 * 60 * 100);

            switch (user.getRole()) {
                case "admin":
                    return "workerProfile";
                case "client":
                    return "profileClient";
                case "director":
                    return "directorProfile";
            }
        }
        return "signinform";
    }

}

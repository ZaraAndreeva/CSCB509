package com.project.controller;

import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.RequestService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/create")
    public String createRequest(HttpServletRequest request, @RequestParam(name = "description") String description,
                                @RequestParam(name = "address") String address) {

        Request requestToSave = new Request();
        User user = (User) request.getSession().getAttribute("user");
        requestToSave.setUserId(user);

        requestToSave.setDescription(description);
        requestToSave.setAddress(address);

        requestToSave.setCreateDate(new Date());
        requestToSave.setIsDone(false);

        requestService.addRequest(requestToSave);
        return "signalsClient";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/fix")
    public String fixRequest(HttpServletRequest request, @RequestParam(name = "requestId") int requestId) {
        User user = (User) request.getSession().getAttribute("user");
        Request requestToSave = requestService.getRequestsById(requestId);

        if (user.getRole().equals("admin")) {
            requestToSave.setFixUser(user);
        } else {
            return "signinform";
        }
        requestToSave.setFixDate(new Date());
        requestToSave.setIsDone(true);

        requestService.addRequest(requestToSave);
        return "workerProfile";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/requests")
    public @ResponseBody
    List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/requestsByDone")
    public @ResponseBody
    List<Request> getAllRequests(@RequestParam(name = "isDone") Boolean isDone) {
        return requestService.getRequestsByDone(isDone);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/requestsByUserId")
    public @ResponseBody
    List<Request> getRequestsByUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Request> requests = requestService.getRequeststsByUser(user.getId());
        request.getSession().setAttribute("requests", requests);
        return requests;
    }

}

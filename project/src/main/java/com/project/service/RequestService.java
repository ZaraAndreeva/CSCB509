package com.project.service;

import com.project.dao.RequestDAO;
import com.project.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestDAO requestDAO;

    public List<Request> getAllRequests() {
        return requestDAO.findAll();
    }

    public List<Request> getRequeststsByUser(int userId) {
        return requestDAO.findRequestByUserId(userId);
    }

    public Request getRequestsById(int id) {
        return requestDAO.findRequestById(id);
    }

    public Request addRequest(Request request) {
        return requestDAO.save(request);
    }

    public List<Request> getRequestsByDone(Boolean isDone) {
        return requestDAO.findRequestByDone(isDone);
    }


//    public List<Request> getProductsByCategory(String category){
//        return requestDAO.findAllByCategory(category);
//    }


//    public List<Request> getProductsByType(String type){
//        return requestDAO.findAllByType(type);
//    }
//
//    public List<Request> getProductsByCategoryAndType(String category, String type){
//        return requestDAO.findAllByCategoryAndType(category, type);
//    }
//
//    public List<String> getAllCategories(){
//        return requestDAO.findAllCategories();
//    }
//
//    public List<String> getAllTypes(){
//        return requestDAO.findAllTypes();
//    }
//
//
//    public void deleteProduct(int id){
//        requestDAO.deleteById(id);
//    }

}

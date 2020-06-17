package com.testtask.userLibrary.service;

import com.testtask.userLibrary.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServise {
     List<User> getAllUsers();
    User getUserById(Long id);
    String getUserFullName(Long id);
    void saveUser(User user);
    User updateUser(User user,String udpFirstName,String updSecondName);
    boolean delete(Long id);

}

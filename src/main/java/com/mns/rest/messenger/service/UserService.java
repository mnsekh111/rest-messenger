/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.service;

import com.mns.rest.messenger.db.DataStore;
import com.mns.rest.messenger.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mns
 */
public class UserService {

    private Map<String, User> userList = DataStore.getUserMap();

    private static UserService userServiceInstance = null;

    public static UserService getInstance() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    private UserService() {
        userList.put("91952677721", new User("mns", "91952677721"));
        userList.put("91952677722", new User("mns2", "91952677722"));
        MessageService.getInstance().initUserMessageStore("91952677721");
        MessageService.getInstance().initUserMessageStore("91952677722");

    }


    public List<User> getAllUsers() {
        return new ArrayList<>(userList.values());
    }

    public User getUser(String id) {
        return userList.get(id);
    }

    public User addNewUser(User user) {
        if (userList.containsKey(user.getName()))
            return null;
        else {
            userList.put(user.getPhoneNumber(), user);
            MessageService.getInstance().initUserMessageStore(user.getPhoneNumber());
            return userList.get(user.getPhoneNumber());
        }
    }

    public User updateUser(String phoneNumber, User user) {
        if (userList.containsKey(phoneNumber)) {
            userList.put(phoneNumber, user);
            return userList.get(phoneNumber);
        } else {
            return null;
        }
    }

    public void deleteUser(String phoneNumber) {
        if (userList.containsKey(phoneNumber)) {
            userList.remove(phoneNumber);
        }
    }
}

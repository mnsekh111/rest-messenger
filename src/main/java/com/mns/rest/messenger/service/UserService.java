/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.service;

import com.mns.rest.messenger.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mns
 */
public class UserService {

    private ArrayList<User> userList = new ArrayList<>();

    public String createUser(String name, String phoneNumber) {
        if (userList.contains(new User(phoneNumber))) {
            return "User already exists";
        } else {
            userList.add(new User(userList.size(), name, phoneNumber));
            return "User added successfully";
        }
    }

    public List<User> getAllUsers() {
        return userList;
    }
}

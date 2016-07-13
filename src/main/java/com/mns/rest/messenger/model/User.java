/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private String name;
    private String phoneNumber;

    public User() {
    }

    public User(String phoneNumber) {
        this.name = "anon";
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return this.phoneNumber.contentEquals(((User) obj).phoneNumber);
    }

    public boolean isUpdated(User user){
        return name.contentEquals(user.getName()) && phoneNumber.contentEquals(user.getPhoneNumber());
    }
}

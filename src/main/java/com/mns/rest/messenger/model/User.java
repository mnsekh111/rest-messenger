/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mns
 */
@XmlRootElement
public class User {

    private long id;
    private String name;
    private String phoneNumber;

    public User() {
    }

    public User(String phoneNumber) {
        this.id = -1;
        this.name = "anon";
        this.phoneNumber = phoneNumber;
    }

    public User(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
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

}

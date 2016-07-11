/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.resources;

import com.mns.rest.messenger.model.User;
import com.mns.rest.messenger.service.UserService;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author mns
 */
@Path("/users")
public class UserResource {

    public static UserService uservice = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return uservice.getAllUsers();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") String userId) {
        return uservice.getUser(userId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        return uservice.addNewUser(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User updateUser(@PathParam("userId") String phoneNumber, User user){
        return uservice.updateUser(phoneNumber,user);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public void deleteUser(@PathParam("userId") String phoneNumber){
        uservice.deleteUser(phoneNumber);
    }

}

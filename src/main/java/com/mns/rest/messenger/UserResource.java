/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger;

import com.mns.rest.messenger.model.User;
import com.mns.rest.messenger.service.UserService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mns
 */
@Path("/users")
public class UserResource {

    public static UserService uservice = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getAllUsers() {
        return uservice.getAllUsers();
    }
}

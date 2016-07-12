/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.resources;

import com.mns.rest.messenger.exception.UserExistsException;
import com.mns.rest.messenger.exception.UserNotFoundException;
import com.mns.rest.messenger.model.User;
import com.mns.rest.messenger.service.UserService;

import java.net.URI;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author mns
 */
@Path("/users")
public class UserResource {

    public static UserService uservice = UserService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        ArrayList<User> list = new ArrayList<>(uservice.getAllUsers());
        GenericEntity<ArrayList<User>> glist = new GenericEntity<ArrayList<User>>(list){};
        return Response.ok().entity(glist).build();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String userId) {
        User user = uservice.getUser(userId);
        if (user == null)
            throw new UserNotFoundException("Phone Number " + userId);
        return Response.ok().entity(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@Context UriInfo info, User user) {
        System.out.println(user.getName()+" "+user.getPhoneNumber());
        User retUser = uservice.addNewUser(user);
        if (retUser == null)
            throw new UserExistsException("Phone Number " + user.getPhoneNumber());

        URI location = info.getAbsolutePathBuilder().path(retUser.getPhoneNumber()).build();
        return Response.created(location).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response updateUser(@Context UriInfo info, @PathParam("userId") String phoneNumber, User user) {
        User retUser = uservice.updateUser(phoneNumber, user);
        if (retUser == null)
            throw new UserNotFoundException("Phone Number " + phoneNumber);


        URI location = info.getAbsolutePathBuilder().path(retUser.getPhoneNumber()).build();
        if (!user.isUpdated(retUser)) {
            return Response.notModified().entity(retUser).build();
        }
        return Response.ok().entity(retUser).location(location).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") String phoneNumber) {
        int status = uservice.deleteUser(phoneNumber);
        if (status == -1)
            throw new UserNotFoundException("Phone Number " + phoneNumber);
        return Response.ok().build();
    }

    @Path("/{userId}/messages")
    public MessageResource redirectMessages(@PathParam("userId") String phoneNumber, @Context UriInfo info) {
        if(getUser(phoneNumber) == null){
            throw new UserNotFoundException("Phone Number " + phoneNumber);
        }

        for(String str : info.getMatchedURIs())
        System.out.println(str);

        return new MessageResource();
    }

}

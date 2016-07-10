package com.mns.rest.messenger.resources;

import com.mns.rest.messenger.model.Message;
import com.mns.rest.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by mns on 8/10/16.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    private static MessageService ms = MessageService.getInstance();


    @GET
    public ArrayList<Message> getAllMessages(@PathParam("userId") String userId) {
        return ms.getMessages(userId);
    }

    @GET
    @Path("/{receiverId}")
    public ArrayList<Message> getAllMessages(@PathParam("receiverId") String receiverId,
                                             @PathParam("userId") String userId) {
        return ms.getMessageReceiver(userId, receiverId);
    }

    @GET
    @Path("/{receiverId}/{id}")
    public Message getMessage(@PathParam("receiverId") String receiverId,
                              @PathParam("userId") String userId,
                              @PathParam("id") String id) {
        return ms.getMessage(userId, receiverId, id);
    }

    @DELETE
    @Path("/{receiverId}")
    public void deleteAllMessages(@PathParam("userId") String userId,
                                  @PathParam("receiverId") String receiverId) {
        ms.deleteMessageReceiver(userId, receiverId);
    }

    @DELETE
    public void deleteAllMessages(@PathParam("userId") String userId) {
        ms.deleteMessages(userId);
    }


    @DELETE
    @Path("/{receiverId}/{id}")
    public void deleteMessage(@PathParam("receiverId") String receiverId,
                              @PathParam("id") String id,
                              @PathParam("userId") String userId) {
        ms.deleteMessage(userId, receiverId, id);
    }

    @POST
    @Path("/{receiverId}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Message addMessage(@PathParam("receiverId") String receiverId,@PathParam("userId") String userId, String message){
        return ms.addMessage(userId,receiverId,message);
    }

}

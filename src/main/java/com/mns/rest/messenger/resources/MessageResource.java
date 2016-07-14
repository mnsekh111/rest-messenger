package com.mns.rest.messenger.resources;

import com.mns.rest.messenger.filters.MessageFilterAnnotation;
import com.mns.rest.messenger.model.Message;
import com.mns.rest.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    private static MessageService ms = MessageService.getInstance();


    @GET
    public Response getAllMessages(@PathParam("userId") String userId) {
        ArrayList<Message> list = new ArrayList<>(ms.getMessages(userId));
        GenericEntity<ArrayList<Message>> glist = new GenericEntity<ArrayList<Message>>(list) {
        };
        return Response.ok(glist).build();
    }

    @GET
    @MessageFilterAnnotation
    @Path("/{receiverId}")
    public Response getAllMessages(@PathParam("receiverId") String receiverId,
                                   @PathParam("userId") String userId) {
        ArrayList<Message> list = new ArrayList<>(ms.getMessageReceiver(userId, receiverId));
        GenericEntity<ArrayList<Message>> glist = new GenericEntity<ArrayList<Message>>(list) {
        };
        return Response.ok(glist).build();
    }

    @GET
    @MessageFilterAnnotation
    @Path("/{receiverId}/{id}")
    public Message getMessage(@PathParam("receiverId") String receiverId,
                              @PathParam("userId") String userId,
                              @PathParam("id") String id) {
        return ms.getMessage(userId, receiverId, id);
    }

    @DELETE
    @MessageFilterAnnotation
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
    @MessageFilterAnnotation
    @Path("/{receiverId}/{id}")
    public void deleteMessage(@PathParam("receiverId") String receiverId,
                              @PathParam("id") String id,
                              @PathParam("userId") String userId) {
        ms.deleteMessage(userId, receiverId, id);
    }

    @POST
    @Path("/{receiverId}")
    @MessageFilterAnnotation
    @Consumes(MediaType.APPLICATION_JSON)
    public Message addMessage(@PathParam("receiverId") String receiverId, @PathParam("userId") String userId, String message) {
        return ms.addMessage(userId, receiverId, message);
    }

}

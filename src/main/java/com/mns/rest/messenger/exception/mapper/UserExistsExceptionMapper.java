package com.mns.rest.messenger.exception.mapper;

import com.mns.rest.messenger.exception.UserExistsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import com.mns.rest.messenger.model.RestError;
import javax.ws.rs.ext.Provider;



@Provider
public class UserExistsExceptionMapper implements ExceptionMapper<UserExistsException>{
    @Override
    public Response toResponse(UserExistsException exception) {
        RestError error = new RestError(exception.getErrorCode(),exception.getMessage());
        return Response.status(Response.Status.CONFLICT)
                .entity(error).build();
    }
}

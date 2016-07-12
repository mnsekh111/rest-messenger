package com.mns.rest.messenger.exception.mapper;

import com.mns.rest.messenger.exception.UserNotFoundException;
import com.mns.rest.messenger.model.RestError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mns on 8/11/16.
 */
@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new RestError(exception.getErrorCode(),exception.getMessage())).build();
    }

}

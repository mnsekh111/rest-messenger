package com.mns.rest.messenger.filters;

import com.mns.rest.messenger.exception.UserNotFoundException;
import com.mns.rest.messenger.service.UserService;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;

@MessageFilterAnnotation
@Provider
public class MessageRequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String [] splitVals = requestContext.getUriInfo().getAbsolutePath().getRawPath().split("/");
        System.out.println(Arrays.toString(splitVals));
        if(splitVals.length > 4){
            String reqId = splitVals[4];
            System.out.println(reqId);

            if(UserService.getInstance().getUser(reqId) == null){
                throw new UserNotFoundException(reqId);
            }
        }

    }
}

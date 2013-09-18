package com.savvis.it.arch.demo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;

@Path("/")
@Produces("application/json")
public class ChatResource {

    /**
     * Suspend the response without writing anything back to the client.
     * @return a white space
     */
    @Suspend(contentType = "application/json")
    @GET
    public String suspend() {
        return "";
    }

    /**
     * Broadcast the received message object to all suspended response. Do not write back the message to the calling connection.
     * @param message a {@link String}
     * @return a {@link Response}
     */
    @Broadcast(writeEntity = false)
    @POST
    @Produces("application/json")
    public String broadcast(String message) {
        return message;
    }

}

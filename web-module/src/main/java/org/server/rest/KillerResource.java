package org.server.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Dragon.Dragon;
import org.server.ejb.interfaces.DragonsBusinessInterface;

@Path("/killer/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KillerResource {
    @EJB(lookup = "java:global/ejb-module/DragonsBusinessBean!org.server.ejb.interfaces.DragonsBusinessInterface")
    private DragonsBusinessInterface dragonsBusiness;

    @GET
    @Path("/dragon/find-by-cave-depth/{type}")
    public Response getExtremumDepthDragon(@PathParam("type") String type) {
        Dragon responseObj = dragonsBusiness.findDeepestDragon(type);
        if (responseObj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(responseObj).build();
    }

    @POST
    @Path("/kill/{id}")
    public Response killDragon(@PathParam("id") long id) {
        dragonsBusiness.killDragon(id);
        return Response.ok().build();
    }
}

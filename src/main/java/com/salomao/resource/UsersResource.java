package com.salomao.resource;


import com.salomao.dtos.UsersDto;
import com.salomao.service.UsersService;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Resource
public class UsersResource {

    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private UsersService usersService;

    public UsersResource(UsersService usersService) {
        this.usersService = usersService;
    }

    @POST
    @Transactional
    public Response createUser(UsersDto usersDto) {
        logger.info("Accessed to create user " );
        try {
            usersService.createUser((usersDto));
            return Response.ok(usersDto, MediaType.APPLICATION_JSON_TYPE).build();
        } catch (Exception e) {
            logger.info("Error creating new user ");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        try {
            var users = usersService.findAll(page, pageSize);
            return Response.ok(users).build();
        }catch (Exception e) {
            logger.info("Error find list not found " + page);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("/id")
    @Produces("application/json")
    @Consumes("application/json")
    public Response findById(@QueryParam("id") Long id) {
        logger.info("Accessed to get user " + id);
        try {
            return Response.ok(usersService.findById(id)).build();
        } catch (Exception e) {
            logger.info("Error find user not found " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("/{name}")
    public Response findByName(@QueryParam("name") String name) {
        logger.info("Accessed to get user " + name);
        try {
            return Response.ok(usersService.findByName(name)).build();
        } catch (Exception e) {
            logger.info("Error find user not found " + name);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("/email")
    public Response findByEmail(@QueryParam("email") String email) {
        logger.info("Accessed to get user " + email);
        try {
            return Response.ok(usersService.findByEmail(email)).build();
        } catch (Exception e) {
            logger.info("Error find user not found " + email);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("/id")
    @DELETE
    @Transactional
    public Response deleteById(Long id) {
        logger.info("Accessed to deleting user " + id);
        try {
            usersService.deleteById(id);
            return Response.noContent().build();
        } catch (Exception e) {
            logger.info("Error deleting user not found " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response updateUsers(@PathParam("id") Long id, UsersDto usersDto) {
        logger.info("Accessed to update user " + id);
        try {
            usersService.updateUsers(id, (usersDto));
            return Response.accepted().build();
        } catch (Exception e) {
            logger.info("Error updating user not found " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}

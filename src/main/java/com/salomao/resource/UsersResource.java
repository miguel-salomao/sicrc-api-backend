package com.salomao.resource;


import com.salomao.dtos.UsersDto;
import com.salomao.exception.NotFoundException;
import com.salomao.service.UsersService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersService usersService;

    public UsersResource(UsersService usersService) {
        this.usersService = usersService;
    }

    @POST
    @Transactional
    public Response createUser(UsersDto usersDto) throws NotFoundException {
        try {
            usersService.createUser((usersDto));
            return Response.ok(usersDto, MediaType.APPLICATION_JSON_TYPE).build();
        } catch (Exception e) {
                e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                             @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var users = usersService.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/id")
    public Response findById(@QueryParam("id") Long id) {
        if (id == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        try {
            return Response.ok(usersService.findById(id)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
@GET
@Path("/name")
    public Response findByName(@QueryParam("name") String name) throws NotFoundException {
        if (name == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        try {
            return Response.ok(usersService.findByName(name)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}

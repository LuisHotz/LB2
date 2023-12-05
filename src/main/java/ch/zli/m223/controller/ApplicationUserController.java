package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;


@Path("/users")
@Tag(name = "Users", description = "Handling of users.")
public class ApplicationUserController {
  
  @Inject
  ApplicationUserService userService;

  @GET
  @RolesAllowed({ "Admin" })
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all users.", 
      description = "Returns a list of all users."
  )
  public List<ApplicationUser> index() {
      return userService.findAll();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Registers a new User.", 
      description = "Registers a new User and returns it."
  )
  @PermitAll
  public ApplicationUser create(ApplicationUser user) {
     return userService.createUser(user);
  }

  @Path("/{id}")
  @DELETE
  @RolesAllowed({ "Admin" })
  @Operation(
      summary = "Deletes a user.",
      description = "Deletes a user by its id."
  )
  public void delete(@PathParam("id") Long id) {
      userService.deleteUser(id);
  }

  @Path("/{id}")
  @PUT
  @RolesAllowed({ "Admin" })
  @Operation(
      summary = "Updates a user.",
      description = "Updates a user by its id."
  )
  public ApplicationUser update(@PathParam("id") Long id, ApplicationUser user) {
      return userService.updateUser(id, user);
  }
}

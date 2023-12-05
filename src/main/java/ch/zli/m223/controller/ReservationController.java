package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
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

import ch.zli.m223.model.Reservation;
import ch.zli.m223.service.ReservationService;

@Path("/reservations")
@Tag(name = "Reservations", description = "Handling of reservations")
public class ReservationController {

    @Inject
    ReservationService reservationService;

    @GET
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all reservations.", description = "Returns a list of all reservations.")
    public List<Reservation> index() {
        return reservationService.findAll();
    }

    @POST
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new reservation.", description = "Creates a new reservation and returns the newly added reservation.")
    public Reservation create(@Valid Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({ "Admin" })
    @Operation(summary = "Deletes a reservation.", description = "Deletes a reservation by its id.")
    public void delete(@PathParam("id") Long id) {
        reservationService.deleteReservation(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({ "Admin" })
    @Operation(summary = "Updates a reservation.", description = "Updates a reservation by its id.")
    public Reservation update(@PathParam("id") Long id, @Valid Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

}

package resources;

import model.Fahrlehrer;
import service.UserService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.Map;


@Path("/Fahrlehrer")
public class LehrerResource {

    final static Map<Integer, Fahrlehrer> lehrer = UserService.queryAllUsers();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Fahrlehrer> getLehrer() {
        return lehrer.values();  // return code is 200
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getLehrer(@PathParam("id") int id) {
        Fahrlehrer fahrlehrer = lehrer.get(id);
        if (fahrlehrer == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // return code is 404
        }
        return Response.ok(fahrlehrer).build(); // return code is 200
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response postLehrer(Fahrlehrer fahrlehrer, @Context UriInfo uriInfo) {
        lehrer.put(fahrlehrer.getFahrlehrerID(), fahrlehrer);
        return Response.ok(fahrlehrer).build();
    }

    @PUT
    @Path("{id}")
    public Response putLehrer(@PathParam("id") int id, @NotNull Fahrlehrer newLehrer, @Context UriInfo uriInfo) {
        boolean exists = lehrer.get(id) != null;
        newLehrer.setFahrlehrerID(id);
        if (!exists) {
            return postLehrer(newLehrer, uriInfo);
        } else {
            lehrer.put(id, newLehrer);
            return Response.ok(lehrer).build(); // return code is 200
        }
    }

    @PATCH
    @Path("{id}")
    public Response patchLehrer(@PathParam("id") int id, @NotNull Fahrlehrer patchedLehrer) {
        Fahrlehrer fahrlehrer = lehrer.get(id);
        boolean exists = fahrlehrer != null;
        if (!exists) {
            return Response.status(404).build(); // return code is 404
        } else {

            return Response.ok(fahrlehrer).build(); // return code is 200
        }
    }

    @DELETE
    public Response deleteAlleLehrer() {
        lehrer.clear();
        return Response.noContent().build(); // return code is 204
    }

    @DELETE
    @Path("{id}")
    public Response deleteLehrer(@PathParam("id") int id) {
        lehrer.remove(id);
        return Response.noContent().build(); // return code is 204
    }
}

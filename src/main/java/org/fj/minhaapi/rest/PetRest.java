package org.fj.minhaapi.rest;

import org.fj.minhaapi.dto.PetDto;
import org.fj.minhaapi.model.Pet;
import org.fj.minhaapi.service.PetService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class PetRest {

    private PetService petService;

    public PetRest(){
        this.petService = new PetService();
    }

    @GET
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPets() {
        List<Pet> atendimentos = this.petService.listarPets();
        return Response.ok(atendimentos).build();
    }

    @POST
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarPets(PetDto petDto) {
        Pet petSalvo = this.petService.salvarPet(petDto);

        if (petSalvo == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salvar pet.")
                    .build();
        }
        URI location = URI.create("/api/pets" + petSalvo.getId());
        return Response
                .created(location)
                .entity(petSalvo)
                .build();
    }
}

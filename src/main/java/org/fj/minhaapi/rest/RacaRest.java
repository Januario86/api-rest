package org.fj.minhaapi.rest;

import org.fj.minhaapi.dto.RacaDto;
import org.fj.minhaapi.model.Raca;
import org.fj.minhaapi.service.RacaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class RacaRest {

    private RacaService racaService;

    public RacaRest(){
        this.racaService = new RacaService();
    }

    @GET
    @Path("/raca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarRacas() {
        List<Raca> raca = this.racaService.listarRaca();
        return Response.ok(raca).build();
    }

    @POST
    @Path("/raca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarRaca(RacaDto racaDTO) {
        Raca racaSalvo = this.racaService.salvarRaca(racaDTO);

        URI location = URI.create("/api/raca" + racaSalvo.getId());
        return Response
                .created(location)
                .entity(racaSalvo)
                .build();
    }

}

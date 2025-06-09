package org.fj.minhaapi.rest;

import org.fj.minhaapi.dto.AtendimentoDto;
import org.fj.minhaapi.model.Atendimento;
import org.fj.minhaapi.service.AtendimentoService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class AtendimentoRest {
    private AtendimentoService atendimentoService;

    public AtendimentoRest(){
        this.atendimentoService = new AtendimentoService();
    }

    @GET
    @Path("/atendimentos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAtendimentos() {
        List<Atendimento> atendimentos = this.atendimentoService.listarAtendimento();
        return Response.ok(atendimentos).build();
    }

    @POST
    @Path("/atendimentos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarAtendimentos(AtendimentoDto atendimentoDto) {
        Atendimento atendimentoSalvo = this.atendimentoService.salvarAtendimento(atendimentoDto);

        URI location = URI.create("/api/atendimentos/" + atendimentoSalvo.getId());
        return Response
                .created(location)
                .entity(atendimentoSalvo)
                .build();
    }
}

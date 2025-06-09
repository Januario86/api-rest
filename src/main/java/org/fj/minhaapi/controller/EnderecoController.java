package org.fj.minhaapi.controller;

import org.fj.minhaapi.dto.EnderecoDto;
import org.fj.minhaapi.dto.RacaDto;
import org.fj.minhaapi.model.Endereco;
import org.fj.minhaapi.model.Raca;
import org.fj.minhaapi.services.EnderecoService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(){
        this.enderecoService = new EnderecoService();
    }

    @GET
    @Path("/enderecos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarEndereco() {
        List<Endereco> endereco = this.enderecoService.listarEndereco();
        return Response.ok(endereco).build();
    }

    @POST
    @Path("/enderecos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarEndereco(EnderecoDto enderecoDto) {
        Endereco enderecoSalvo = this.enderecoService.salvarEndereco(enderecoDto);

        URI location = URI.create("/api/endereco" + enderecoSalvo.getId());
        return Response
                .created(location)
                .entity(enderecoSalvo)
                .build();
    }





}





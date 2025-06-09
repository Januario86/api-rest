package org.fj.minhaapi.rest;

import org.fj.minhaapi.dto.ClienteDto;
import org.fj.minhaapi.mapper.ClienteMapper;
import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.response.ClienteResponse;
import org.fj.minhaapi.service.ClienteService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class ClientesRest {

    private ClienteService clienteService;

    public ClientesRest(){
        this.clienteService = new ClienteService();
    }

    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        List<Cliente> clientes = this.clienteService.listarCliente();
        return Response.ok(clientes).build();
    }

    @POST
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarCliente(ClienteDto clienteDTO) {
        Cliente clienteSalvo = this.clienteService.salvarCliente(clienteDTO);
        ClienteResponse response = ClienteMapper.toResponse(clienteSalvo);

        URI location = URI.create("/api/clientes/" + clienteSalvo.getId());
        return Response
                .created(location)
                .entity(response)
                .build();
    }
}
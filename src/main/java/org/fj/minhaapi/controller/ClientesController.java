package org.fj.minhaapi.controller;

import org.fj.minhaapi.dto.ClienteDto;
import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.services.ClienteService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api")
public class ClientesController {

    private ClienteService clienteService;

    public ClientesController(){
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

        URI location = URI.create("/api/clientes/" + clienteSalvo.getId());
        return Response
                .created(location)
                .entity(clienteSalvo)
                .build();
    }
}
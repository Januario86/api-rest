package org.fj.minhaapi.controller;

import DTO.ClienteDTO;
import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.model.User;
import org.fj.minhaapi.services.ClienteService;
import org.fj.minhaapi.services.UsuarioService;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response salvarCliente(ClienteDTO clienteDTO) {
        this.clienteService.salvarCliente(clienteDTO);
        return Response.ok("Sucesso").build();
    }




}
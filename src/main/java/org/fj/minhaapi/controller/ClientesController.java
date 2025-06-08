package org.fj.minhaapi.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class ClientesController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/listar")  // Caminho completo: /api/hello
    @Produces(MediaType.TEXT_PLAIN)
    public String listarClientes() {
        return "Hello, World!";
    }
}
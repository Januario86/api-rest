package org.fj.minhaapi.controller;

import org.fj.minhaapi.model.User;
import org.fj.minhaapi.services.UsuarioService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class UserController {

    private UsuarioService usuarioService;

    public UserController(){
        this.usuarioService = new UsuarioService();
    }
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        List<User> usuarios = this.usuarioService.listarUsuarios();
        return Response.ok(usuarios).build();
    }
//    @GET
//    @Path("/usuarios")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listarUsuarios() {
//        List<String> usuarios = new ArrayList<>();
//        usuarios.add("João");
//        usuarios.add("Maria");
//        usuarios.add("Pedro");
//        return Response.ok(usuarios).build();
//    }
}

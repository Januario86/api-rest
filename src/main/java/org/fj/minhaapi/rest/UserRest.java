package org.fj.minhaapi.rest;

import org.fj.minhaapi.model.User;
import org.fj.minhaapi.service.UsuarioService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api")
public class UserRest {

    private UsuarioService usuarioService;

    public UserRest(){
        this.usuarioService = new UsuarioService();
    }
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        List<User> usuarios = this.usuarioService.listarUsuarios();
        return Response.ok(usuarios).build();
    }
}

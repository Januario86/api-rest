package org.fj.minhaapi.rest;

import org.fj.minhaapi.dto.CredenciaisDto;
import org.fj.minhaapi.model.User;
import org.fj.minhaapi.service.UsuarioService;
import org.fj.minhaapi.utils.TokenUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
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

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(CredenciaisDto credenciaisDto) {
       var usuario = this.usuarioService.login(credenciaisDto);
        String senhaHash = BCrypt.hashpw(credenciaisDto.senha(), BCrypt.gensalt());
        usuario.setSenha(senhaHash);

        if (usuario.getLogin().equals(credenciaisDto.login()) && BCrypt.checkpw(credenciaisDto.senha(), usuario.getSenha())) {

            String token = TokenUtil.generateToken(usuario);
            return Response.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .entity("{\"token\": \"" + token + "\"}")
                    .build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"error\": \"Usuário ou senha inválidos\"}").build();
    }
}

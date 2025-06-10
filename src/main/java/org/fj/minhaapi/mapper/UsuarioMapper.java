package org.fj.minhaapi.mapper;

import org.fj.minhaapi.model.Usuario;
import org.fj.minhaapi.response.UsuarioResponse;

public class UsuarioMapper {
    public static UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        return response;
    }
}

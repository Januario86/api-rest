package org.fj.minhaapi.mapper;

import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.response.ClienteResponse;

public class ClienteMapper {
    public static ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setCpf(cliente.getCpf());
        response.setDataCadastro(cliente.getDataCadastro());
        return response;
    }
}

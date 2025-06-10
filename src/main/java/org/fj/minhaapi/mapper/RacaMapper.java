package org.fj.minhaapi.mapper;

import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.model.Raca;
import org.fj.minhaapi.response.ClienteResponse;
import org.fj.minhaapi.response.RacaResponse;

public class RacaMapper {
    public static RacaResponse toResponse(Raca raca) {
        RacaResponse response = new RacaResponse();
        response.setId(raca.getId());
        return response;
    }
}

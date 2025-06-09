package org.fj.minhaapi.dto;

import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.model.Raca;

import java.util.Date;

public record PetDto(Cliente cliente,
                     String nome,
                     String tipo,
                     Raca raca,
                     Date dataNascimento) {
}

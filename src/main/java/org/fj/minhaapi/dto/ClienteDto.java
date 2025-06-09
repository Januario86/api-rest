package org.fj.minhaapi.dto;

import java.time.LocalDateTime;

public record ClienteDto(String nome, String cpf, LocalDateTime dataCadastro) {
}

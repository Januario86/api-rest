package DTO;

import java.time.LocalDateTime;

public record ClienteDTO(String nome, String cpf, LocalDateTime dataCadastro) {
}

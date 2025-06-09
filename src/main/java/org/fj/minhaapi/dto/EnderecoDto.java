package org.fj.minhaapi.dto;

import org.fj.minhaapi.model.Cliente;

public record EnderecoDto(Long id,
                          Cliente cliente,
                          String logradouro,
                          String cidade,
                          String bairro,
                          String complemento,
                          String tag) {
}

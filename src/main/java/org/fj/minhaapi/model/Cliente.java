package org.fj.minhaapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDateTime  dataCadastro;

    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDateTime.now();
        }
    }
}
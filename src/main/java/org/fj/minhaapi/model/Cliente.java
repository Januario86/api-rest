package org.fj.minhaapi.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataCadastro;

    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = new Date();
        }
    }
}
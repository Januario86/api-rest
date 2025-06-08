package org.fj.minhaapi.model;

import lombok.Data;

@Data
public class Contato {

    private Long id;
    private Cliente cliente;

    private String tag;
    private String tipo;
    private String valor;

}

package org.fj.minhaapi.model;

import lombok.Data;

@Data
public class Endereco {

    private Long id;
    private Cliente cliente;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String tag;

}
package org.fj.minhaapi.model;

import lombok.Data;

@Data
public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private Perfil perfil;

}
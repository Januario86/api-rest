package org.fj.minhaapi.model;

import lombok.Data;

@Data
public class Usuario {

	private String cpf;

    private String nome;
    private String senha;
    
    private Perfil perfil;

}
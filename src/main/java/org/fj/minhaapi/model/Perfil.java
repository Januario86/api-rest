package org.fj.minhaapi.model;

public enum Perfil {

	ADMIN,
	USUARIO;
	
	public String getRole() {
        return "ROLE_" + this.name();
    }
}
package org.fj.minhaapi.model;

public enum Perfil {

	 CLIENTE,
	 ADMIN;
	
	public String getRole() {
        return "ROLE_" + this.name();
    }
}
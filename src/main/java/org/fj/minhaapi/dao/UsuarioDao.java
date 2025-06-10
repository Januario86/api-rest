package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> findAll();
    Usuario findById(Long id);
    void insert(Usuario usuario);
    void update(Usuario usuario);
    void delete(Long id);
    Usuario findByLogin(String login);
}

package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Contato;
import org.fj.minhaapi.model.User;

import java.util.List;

public interface ContatoDao {
    List<Contato> findAll();
    User findById(Long id);
    void insert(Contato contato);
    void update(Contato contato);
    void delete(Long id);

}

package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Endereco;
import org.fj.minhaapi.model.User;

import java.util.List;

public interface EnderecoDao {
    List<Endereco> findAll();
    User findById(Long id);
    void insert(Endereco endereco);
    void update(Endereco endereco);
    void delete(Long id);
}

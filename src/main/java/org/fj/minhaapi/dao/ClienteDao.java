package org.fj.minhaapi.dao;


import org.fj.minhaapi.model.Cliente;
import org.fj.minhaapi.model.User;

import java.util.List;

public interface ClienteDao {
    List<Cliente> findAll();
    User findById(Long id);
    void insert(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);


}

package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Raca;

import java.util.List;

public interface RacaDao {
    List<Raca> findAll();
    Raca findById(Long id);
    void insert(Raca raca);
    void update(Raca raca);
    void delete(Long id);
}

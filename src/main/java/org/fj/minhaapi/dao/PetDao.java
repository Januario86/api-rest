package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Pet;
import org.fj.minhaapi.model.User;

import java.util.List;

public interface PetDao {
    List<Pet> findAll();
    User findById(Long id);
    void insert(Pet pet);
    void update(Pet Pet);
    void delete(Long id);
}

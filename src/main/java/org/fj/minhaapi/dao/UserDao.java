package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.User;

import java.util.List;

public interface UserDao {
        List<User> findAll();
        User findById(Long id);
        void insert(User user);
        void update(User user);
        void delete(Long id);
}

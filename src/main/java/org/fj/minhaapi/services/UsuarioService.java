package org.fj.minhaapi.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.UserDao;
import org.fj.minhaapi.model.User;

import java.util.List;

public class UsuarioService {

    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<User> listarUsuarios() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao mapper = session.getMapper(UserDao.class);

            List<User> users = mapper.findAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

}

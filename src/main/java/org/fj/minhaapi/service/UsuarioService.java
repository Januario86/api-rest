package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.UserDao;
import org.fj.minhaapi.dao.UsuarioDao;
import org.fj.minhaapi.dto.CredenciaisDto;
import org.fj.minhaapi.model.User;
import org.fj.minhaapi.model.Usuario;

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

    public Usuario login(CredenciaisDto credenciais) {try {
        SqlSession session = sqlSessionFactory.openSession();
        UsuarioDao mapper = session.getMapper(UsuarioDao.class);

        Usuario user = mapper.findByLogin(credenciais.login());
        return user;
    } catch (Exception e) {
        e.printStackTrace();
        e.getMessage();
    }
        return null;
    }
}

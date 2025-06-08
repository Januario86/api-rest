package org.fj.demo.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fj.demo.dao.UserDao;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisConfig {

    private static SqlSessionFactory sqlSessionFactory;

    public MyBatisConfig() {
        try {
            String resource = "mybatis-config.xml"; // no classpath (src/main/resources)
            InputStream inputStream = Resources.getResourceAsStream(resource);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar SqlSessionFactory", e);
        }
    }

    public SqlSessionFactory produceSqlSessionFactory() throws IOException {
        String resource = "meu/pacote/mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        return factory;
    }

    public SqlSession produceSqlSession(SqlSessionFactory factory) {
        return factory.openSession(); // false = sem auto-commit
    }

    public void closeSqlSession( SqlSession session) {
        if (session != null) {
            session.close();
        }
    }

    public UserDao produceUserDao(SqlSession session) {
        return session.getMapper(UserDao.class);
    }
}

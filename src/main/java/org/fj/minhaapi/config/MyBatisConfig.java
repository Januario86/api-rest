package org.fj.minhaapi.config;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fj.minhaapi.dao.UserDao;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConfig {
    @Getter
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing MyBatis"+ e.getMessage(),e);
        }
    }
}

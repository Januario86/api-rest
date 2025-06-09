package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.RacaDao;
import org.fj.minhaapi.dto.RacaDto;
import org.fj.minhaapi.model.Raca;

import java.util.List;

public class RacaService {
    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<Raca> listarRaca() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            RacaDao mapper = session.getMapper(RacaDao.class);

            List<Raca> raca = mapper.findAll();
            session.close();
            return raca;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

    public Raca salvarRaca(RacaDto racaDTO) {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            RacaDao mapper = session.getMapper(RacaDao.class);

            Raca novaRaca = new Raca();
            novaRaca.setDescricao(racaDTO.descricao());
            mapper.insert(novaRaca);

            session.commit();
            session.close();
            return novaRaca;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }

}

package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.AtendimentoDao;
import org.fj.minhaapi.dto.AtendimentoDto;
import org.fj.minhaapi.model.Atendimento;

import java.util.Date;
import java.util.List;

public class AtendimentoService {
    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<Atendimento> listarAtendimento() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            AtendimentoDao mapper = session.getMapper(AtendimentoDao.class);

            List<Atendimento> atendimentos = mapper.findAll();
            session.close();
            return atendimentos;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

    public Atendimento salvarAtendimento(AtendimentoDto atendimentoDto) {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            AtendimentoDao mapper = session.getMapper(AtendimentoDao.class);

            Atendimento novoAtendimento = new Atendimento();
            novoAtendimento.setDescricaoAtendimento(atendimentoDto.descricaoAtendimento());
            novoAtendimento.setPets(atendimentoDto.pets());
            novoAtendimento.setValor(atendimentoDto.valor());
            novoAtendimento.setData(new Date());

            mapper.insert(novoAtendimento);

            session.commit();
            session.close();
            return novoAtendimento;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }
}

package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.EnderecoDao;
import org.fj.minhaapi.dto.EnderecoDto;
import org.fj.minhaapi.model.Endereco;

import java.util.List;

public class EnderecoService {

    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<Endereco> listarEndereco() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            EnderecoDao mapper = session.getMapper(EnderecoDao.class);

            List<Endereco> enderecos = mapper.findAll();
            session.close();
            return enderecos;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

    public Endereco salvarEndereco(EnderecoDto enderecoDto) {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            EnderecoDao mapper = session.getMapper(EnderecoDao.class);

            Endereco novoEndereco = new Endereco();
            novoEndereco.setComplemento(enderecoDto.complemento());
            novoEndereco.setBairro(enderecoDto.bairro());
            novoEndereco.setCidade(enderecoDto.cidade());
            novoEndereco.setCliente(enderecoDto.cliente());
            novoEndereco.setLogradouro(enderecoDto.logradouro());
            novoEndereco.setTag(enderecoDto.tag());

            mapper.insert(novoEndereco);

            session.commit();
            session.close();
            return novoEndereco;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }






}

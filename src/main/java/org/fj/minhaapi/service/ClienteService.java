package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.ClienteDao;
import org.fj.minhaapi.dto.ClienteDto;
import org.fj.minhaapi.model.Cliente;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ClienteService {

    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<Cliente> listarCliente() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
           ClienteDao mapper = session.getMapper(ClienteDao.class);

            List<Cliente> clientes = mapper.findAll();
            session.close();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

    public Cliente salvarCliente(ClienteDto cliente) {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            ClienteDao mapper = session.getMapper(ClienteDao.class);

            Cliente novoCliente = new Cliente();
            novoCliente.setNome(cliente.nome());
            novoCliente.setCpf(cliente.cpf());
            novoCliente.setDataCadastro(LocalDateTime.now());

            mapper.insert(novoCliente);

            session.commit();
            session.close();
            return novoCliente;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
      return null;
    }
}

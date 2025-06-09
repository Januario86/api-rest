package org.fj.minhaapi.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fj.minhaapi.config.MyBatisConfig;
import org.fj.minhaapi.dao.PetDao;
import org.fj.minhaapi.dto.PetDto;
import org.fj.minhaapi.model.Pet;

import java.util.List;

public class PetService {
    SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public List<Pet> listarPets() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            PetDao mapper = session.getMapper(PetDao.class);

            List<Pet> pets = mapper.findAll();
            session.close();
            return pets;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return List.of();
    }

    public Pet salvarPet(PetDto petDto) {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            PetDao mapper = session.getMapper(PetDao.class);

            Pet novoPet = new Pet();
            novoPet.setNome(petDto.nome());
            novoPet.setCliente(petDto.cliente());
            novoPet.setDataNascimento(petDto.dataNascimento());
            novoPet.setRaca(petDto.raca());

            mapper.insert(novoPet);

            session.commit();
            session.close();
            return novoPet;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }

}

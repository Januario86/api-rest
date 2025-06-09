package org.fj.minhaapi.dao;

import org.fj.minhaapi.model.Atendimento;
import java.util.List;

public interface AtendimentoDao {
    List<Atendimento> findAll();
    Atendimento findById(Long id);
        void insert(Atendimento atednimento);
        void update(Atendimento atednimento);
        void delete(Long id);
}


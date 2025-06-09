package org.fj.minhaapi.dto;

import org.fj.minhaapi.model.Pet;
import java.time.LocalDate;
import java.util.Date;

public record AtendimentoDto(Long id,
                             Pet pets,
                             String descricaoAtendimento,
                             Double valor,
                             Date data) {
}

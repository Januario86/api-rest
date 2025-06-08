package org.fj.minhaapi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Atendimento {

	private Long id;
	private Pet pets;
	private String descricaoAtendimento;
	private Double valor;
	private LocalDate data;
}
package org.fj.minhaapi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet {

	private Long id;
	private Cliente cliente;
	private Raca raca;

	private String nome;
	private LocalDate dataNascimento;

}
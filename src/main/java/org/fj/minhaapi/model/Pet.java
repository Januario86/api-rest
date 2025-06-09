package org.fj.minhaapi.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Pet {

	private Long id;
	private Cliente cliente;
	private Raca raca;

	private String nome;
	private Date dataNascimento;
}
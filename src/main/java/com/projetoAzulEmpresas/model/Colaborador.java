package com.projetoAzulEmpresas.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Colaborador implements Serializable{
	
	private static final long serialVersionUID = -705125855413216034L;
	
	@Id @JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@JsonIgnore
	private String cpf;
	@JsonIgnore
	private String telefone;
	private String email;
	@ManyToOne
	@JsonBackReference
	private Setor setor;
	
	public Colaborador(Long id, String nome, String cpf, String telefone, String email, Setor setor) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.setor = setor;
	}

	public Colaborador() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

}

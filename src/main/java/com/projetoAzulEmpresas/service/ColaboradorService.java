package com.projetoAzulEmpresas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAzulEmpresas.dto.ColaboradorDto;
import com.projetoAzulEmpresas.model.Colaborador;
import com.projetoAzulEmpresas.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colabRepository;
	
	public Colaborador inserir(Colaborador colaborador) {
		return colabRepository.save(colaborador);
	}
	
	public void remover(Long id) {
		colabRepository.deleteById(id);
	}
	
	public Optional<Colaborador> buscar(Long id) {
		return colabRepository.findById(id);
	}

}

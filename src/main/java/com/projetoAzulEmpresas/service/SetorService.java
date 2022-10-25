package com.projetoAzulEmpresas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAzulEmpresas.model.Setor;
import com.projetoAzulEmpresas.repository.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;
	
	
//	public Setor cadastrar(Setor setor) {
//		return setorRepository.save(setor);
//	}
	
	
	public Optional<Setor>  findById(Long id){
		Optional<Setor> setor = setorRepository.findById(id);
		return setor;
	}
	
	public List<Setor> listar() {
		return setorRepository.findAll();
	}

}

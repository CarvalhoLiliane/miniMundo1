package com.projetoAzulEmpresas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAzulEmpresas.model.Setor;
import com.projetoAzulEmpresas.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
	
	@Autowired
	private SetorService setorService;
	//private ModelMapper mapper;
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public SetorDto inserir(@RequestBody SetorDto setorDto) {
//		mapper = new ModelMapper();
//		Setor setor = mapper.map(setorDto, Setor.class);
//		Setor novoSetor = setorService.cadastrar(setor);
//		
//		return mapper.map(novoSetor, SetorDto.class);
//	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Setor> buscar(@PathVariable Long id){
		Optional<Setor> setor = setorService.findById(id);
		return setor;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Setor> listar(){
		return setorService.listar();
	}

}

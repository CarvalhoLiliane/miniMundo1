package com.projetoAzulEmpresas.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAzulEmpresas.dto.ColaboradorDto;
import com.projetoAzulEmpresas.model.Colaborador;
import com.projetoAzulEmpresas.model.Setor;
import com.projetoAzulEmpresas.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colabService;
	private ModelMapper mapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ColaboradorDto inserir(@RequestBody ColaboradorDto colaboradorDto) {
		mapper = new ModelMapper();
		Colaborador colaborador = mapper.map(colaboradorDto, Colaborador.class);
		colaborador.setSetor(new Setor(Long.parseLong(colaboradorDto.getIdSetor()), ""));
		Colaborador colaboradorNovo = colabService.inserir(colaborador);
		
		return mapper.map(colaboradorNovo, ColaboradorDto.class);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		colabService.remover(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Colaborador> buscar(@PathVariable Long id) {
		return colabService.buscar(id);
	}

}

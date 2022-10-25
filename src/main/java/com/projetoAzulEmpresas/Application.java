package com.projetoAzulEmpresas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetoAzulEmpresas.model.Setor;
import com.projetoAzulEmpresas.repository.SetorRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private SetorRepository setorRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Setor setor1 = new Setor(null, "TI");
		Setor setor2 = new Setor(null, "Administração");
		Setor setor3 = new Setor(null, "RH");
		
		setorRepository.saveAll(Arrays.asList(setor1, setor2, setor3));
		
	}

}

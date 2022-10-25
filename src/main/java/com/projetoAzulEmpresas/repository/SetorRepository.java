package com.projetoAzulEmpresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoAzulEmpresas.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}

package com.spring.crud.repository;
import com.spring.crud.model.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    Candidato findByNome(String nome);

}
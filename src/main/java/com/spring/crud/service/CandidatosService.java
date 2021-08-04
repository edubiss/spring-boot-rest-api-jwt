package com.spring.crud.service;

import java.util.List;
import java.util.Optional;

import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.exception.FieldRequiredException;
import com.spring.crud.model.Candidato;
import com.spring.crud.model.dto.CandidatoDTO;
import com.spring.crud.repository.CandidatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatosService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	public List<Candidato> findAll() {
		return candidatoRepository.findAll();
	}

	public Optional<Candidato> findById(Long id) {
		return candidatoRepository.findById(id);
	}

	public Candidato create(CandidatoDTO candidatoDTO) {		
		Candidato candidato = new Candidato(candidatoDTO);
		candidatoRepository.save(candidato);

		return candidato;
	}

	public Candidato update(CandidatoDTO candidatoDTO) {
		if (candidatoDTO.getId() == null) {
			throw new FieldRequiredException("id do candidato");
		}	

		Optional<Candidato> candidato = candidatoRepository.findById(candidatoDTO.getId());

		candidato.ifPresentOrElse(c -> {
			c.setNome(candidatoDTO.getNome());
			candidatoRepository.save(c);
		}, () -> {
			throw new EntityNotFoundException("candidato com id " + candidatoDTO.getId());
		});

		return candidato.get();
	}

	public void delete(Long id) {
		if (id == null) {
			throw new FieldRequiredException("id do candidato");
		}

		Optional<Candidato> candidato = candidatoRepository.findById(id);

		candidato.ifPresentOrElse(c -> {
			candidatoRepository.delete(c);
		}, () -> {
			throw new EntityNotFoundException("candidato com id " + id);
		});
	}
}
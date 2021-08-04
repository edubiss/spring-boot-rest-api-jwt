package com.spring.crud.controller;
import java.util.List;

import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.model.Candidato;
import com.spring.crud.model.dto.CandidatoDTO;
import com.spring.crud.service.CandidatosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CandidatosController {

    @Autowired
    private CandidatosService candidatosService;

    @GetMapping(value = "/candidatos")
    public List<Candidato> getCandidatos() {
        return candidatosService.findAll();
    }

    @PostMapping(value = "/candidato")
    public ResponseEntity<Candidato> insertCandidato(@RequestBody CandidatoDTO candidatoDTO) {
        return ResponseEntity.ok(candidatosService.create(candidatoDTO));
    }

    @PutMapping(value = "/candidato")
    public ResponseEntity<Candidato> updateCandidato(@RequestBody CandidatoDTO candidatoDTO) {
        return ResponseEntity.ok(candidatosService.update(candidatoDTO));
    }

    @GetMapping(value = "/candidato/{id}")
    public ResponseEntity<Candidato> getCandidatoById(@PathVariable Long id) {        
        if (candidatosService.findById(id).isPresent()) {
            return ResponseEntity.ok(candidatosService.findById(id).get());
        }
            
        throw new EntityNotFoundException("candidato");
    }

    @DeleteMapping(value = "/candidato/{id}")
    public ResponseEntity<?> deleteCandidato(@PathVariable Long id) {
        candidatosService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
package com.spring.crud.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.crud.model.dto.CandidatoDTO;

@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    private List<CartaoCredito> cartoesCredito = new ArrayList<>();

    public Candidato() {
        super();
    }

    public Candidato(CandidatoDTO candidatoDTO) {
        this.nome = candidatoDTO.getNome();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CartaoCredito> getCartoesCredito() {
        return this.cartoesCredito;
    }

    public void addCartaoCredito(CartaoCredito cartaoCredito) {
        cartaoCredito.setCandidato(this);
        this.cartoesCredito.add(cartaoCredito);
    }

    public void removeCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartoesCredito.remove(cartaoCredito);
    }
}


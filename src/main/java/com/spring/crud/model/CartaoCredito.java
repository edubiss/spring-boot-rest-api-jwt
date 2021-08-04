package com.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.crud.model.dto.CartaoCreditoDTO;

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String numero;

    @Column
    private String validade;

    @Column(name = "codigo_seguranca")
    private String codigoSeguranca;

    @ManyToOne
    @JsonIgnore
    private Candidato candidato;

    public CartaoCredito() {
        super();
    }

    public CartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        this.numero = cartaoCreditoDTO.getNumero();
        this.validade = cartaoCreditoDTO.getValidade();
        this.codigoSeguranca = cartaoCreditoDTO.getCodigoSeguranca();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return this.validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCodigoSeguranca() {
        return this.codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Candidato getCandidato() {
        return this.candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

}

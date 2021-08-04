package com.spring.crud.repository;

import java.util.List;

import com.spring.crud.model.CartaoCredito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

   List<CartaoCredito> findByCandidatoId(Long id);
}

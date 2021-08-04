package com.spring.crud.controller;

import java.util.List;

import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.model.Candidato;
import com.spring.crud.model.CartaoCredito;
import com.spring.crud.model.dto.CartaoCreditoDTO;
import com.spring.crud.service.CartaoCreditoService;

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
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @GetMapping(value = "/candidatos/{id}/cartoes")
    public List<CartaoCredito> getCartoesCandidatos(@PathVariable Long id) {
        return cartaoCreditoService.findAllByCandidatoId(id);
    }

    @PutMapping(value = "/cartaoCredito")
    public ResponseEntity<CartaoCredito> atualizarCartao(@RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        return ResponseEntity.ok(cartaoCreditoService.atualizarCartaoCredito(cartaoCreditoDTO));
    }

    @PostMapping(value = "/candidato/{id}/adicionarCartao")
    public ResponseEntity<Candidato> adicionarCartao(@PathVariable Long id, @RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        return ResponseEntity.ok(cartaoCreditoService.adicionarCartaoCredito(id, cartaoCreditoDTO));
    }

    @GetMapping(value = "/cartaoCredito/{idCartao}")
    public ResponseEntity<CartaoCredito> getCartao(@PathVariable Long idCartao) {
        if (cartaoCreditoService.findById(idCartao).isPresent()) {
            return ResponseEntity.ok(cartaoCreditoService.findById(idCartao).get());
        }
            
        throw new EntityNotFoundException("cartão crédito");
    }

    @DeleteMapping(value = "/cartaoCredito/{idCartao}")
    public ResponseEntity<?> removerCartao(@PathVariable Long idCartao) {
        cartaoCreditoService.removerCartaoCredito(idCartao);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

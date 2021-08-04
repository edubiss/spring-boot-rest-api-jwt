package com.spring.crud.service;

import java.util.List;
import java.util.Optional;

import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.exception.FieldRequiredException;
import com.spring.crud.model.Candidato;
import com.spring.crud.model.CartaoCredito;
import com.spring.crud.model.dto.CartaoCreditoDTO;
import com.spring.crud.repository.CandidatoRepository;
import com.spring.crud.repository.CartaoCreditoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoCreditoService {

    @Autowired
	private CandidatoRepository candidatoRepository;
    
    @Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

    public Optional<CartaoCredito> findById(Long id) {
		return cartaoCreditoRepository.findById(id);
	}

	public Candidato adicionarCartaoCredito(Long id, CartaoCreditoDTO cartaoCreditoDTO) {
		Optional<Candidato> candidato = candidatoRepository.findById(id);

		candidato.ifPresentOrElse(c -> {
			c.addCartaoCredito(new CartaoCredito(cartaoCreditoDTO));
			candidatoRepository.save(c);
		}, () -> {
			throw new EntityNotFoundException("candidato com id " + id);
		});

		return candidato.get();
	}

    public CartaoCredito removerCartaoCredito(Long idCartao) {
        if (idCartao == null) {
			throw new FieldRequiredException("id do cartão de crédito");
		}
		Optional<CartaoCredito> cartaoCredito = this.findById(idCartao);

		cartaoCredito.ifPresentOrElse(cartao -> {
		    cartaoCreditoRepository.delete(cartao);
		}, () -> {
			throw new EntityNotFoundException("cartão crédito com id " + idCartao);
		});		

		return cartaoCredito.get();
    }

    public List<CartaoCredito> findAllByCandidatoId(Long id) {
        return cartaoCreditoRepository.findByCandidatoId(id);
    }

    public CartaoCredito atualizarCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        if (cartaoCreditoDTO.getId() == null) {
			throw new FieldRequiredException("id do cartão de crédito");
		}
        
        Optional<CartaoCredito> cartaoCredito = cartaoCreditoRepository.findById(cartaoCreditoDTO.getId());

		cartaoCredito.ifPresentOrElse(cc -> {
			cc.setNumero(cartaoCreditoDTO.getNumero());
            cc.setValidade(cartaoCreditoDTO.getValidade());
            cc.setCodigoSeguranca(cartaoCreditoDTO.getCodigoSeguranca());
			cartaoCreditoRepository.save(cc);
		}, () -> {
			throw new EntityNotFoundException("candidato com id " + cartaoCreditoDTO.getId());
		});

		return cartaoCredito.get();
    }
}

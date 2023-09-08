package com.algaworks.algafood.client.model.input;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput {
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaInput cozinha;
    private EnderecoInput endereco;
}

package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.input.CidadeInput;
import com.algaworks.algafood.client.model.input.CozinhaInput;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class CriarRestauranteMain {
    public static void main(String[] args) {
        try {
            RestauranteClient restauranteClient = new RestauranteClient(new RestTemplate(), "http://localhost:3001");

            RestauranteInput restaurante = new RestauranteInput();
            restaurante.setNome("Thai Delivery");
            restaurante.setTaxaFrete(BigDecimal.valueOf(10.0));

            CozinhaInput cozinha = new CozinhaInput();
            cozinha.setId(String.valueOf(1L));

            EnderecoInput endereco = new EnderecoInput();
            endereco.setCep("0000001");
            endereco.setLogradouro("Rua do Bairro");
            endereco.setComplemento("Casa");
            endereco.setBairro("Bairro Alto");
            endereco.setNumero("Numero 2");

            CidadeInput cidade = new CidadeInput();
            cidade.setId("1");

            endereco.setCidade(cidade);

            restaurante.setEndereco(endereco);
            restaurante.setCozinha(cozinha);

            var result = restauranteClient.cadastrar(restaurante);
            System.out.println(result);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.err.println(e.getProblem());
            }
        }
    }
}

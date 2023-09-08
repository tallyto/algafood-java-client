package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.RestauranteResumoModel;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ListagemRestaurantesMain {
    public static void main(String[] args) {
        try {
            RestauranteClient restauranteClient = new RestauranteClient(new RestTemplate(), "http://localhost:3001");

            List<RestauranteResumoModel> restaurantes = restauranteClient.listar();

            restaurantes.forEach(System.out::println);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.err.println(e.getProblem());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }
    }


}

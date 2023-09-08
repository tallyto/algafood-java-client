package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {
    private static final String RESOURCE_PATH = "/restaurantes";

    private RestTemplate restTemplate;

    private String url;

    public List<RestauranteResumoModel> listar() {
        try {
            String resourceUri = url + RESOURCE_PATH;
            RestauranteResumoModel[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumoModel[].class);
            assert restaurantes != null;
            return Arrays.asList(restaurantes);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }

    }
}

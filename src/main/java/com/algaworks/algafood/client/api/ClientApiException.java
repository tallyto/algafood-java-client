package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.Problem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

@Getter
@Slf4j
public class ClientApiException extends RuntimeException {

    private Problem problem;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        deserializeProblem(cause);
    }

    private void deserializeProblem(RestClientResponseException cause) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        try {
            this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
        } catch (JsonProcessingException e) {
            log.warn("Não foi possível desserializar a resposta em um problema", e);
        }
    }
}

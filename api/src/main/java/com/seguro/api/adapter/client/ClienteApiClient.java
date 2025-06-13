package com.seguro.api.adapter.client;

import com.seguro.api.adapter.client.dto.ClienteDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteApiClient {

    private final RestTemplate restTemplate;

    public ClienteApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDTO buscarClientePorId(Long idCliente) {
        try {
            String url = "http://localhost:8080/api/clientes/" + idCliente;
            return restTemplate.getForObject(url, ClienteDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Cliente não encontrado na API de Cadastro.");
        }
    }
}

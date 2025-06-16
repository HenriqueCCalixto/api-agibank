package com.seguro.api.adapter.client.cliente;

import com.seguro.api.adapter.client.dto.cliente.ClienteDTO;
import com.seguro.api.domain.exceptions.ClienteNaoEncontradoException;
import com.seguro.api.domain.exceptions.ServiceNotFound;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteAPIClient {

    private final RestTemplate restTemplate;

    public ClienteAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "buscarCliente", fallbackMethod = "buscarClienteFallback")
    public ClienteDTO buscarClientePorId(Long idCliente) {
        String url = "http://localhost:8080/api/clientes/" + idCliente;
        try {
            return restTemplate.getForObject(url, ClienteDTO.class);
        } catch (HttpClientErrorException e) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + idCliente);
        }
    }

    private ClienteDTO buscarClienteFallback(Long idCliente, Throwable throwable) {
        if (throwable instanceof ClienteNaoEncontradoException) {
            throw (ClienteNaoEncontradoException) throwable;
        } else {
            throw new ServiceNotFound("Serviço de cliente não disponível no momento.");
        }
    }

}

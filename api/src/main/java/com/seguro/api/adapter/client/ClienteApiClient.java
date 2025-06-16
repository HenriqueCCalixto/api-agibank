package com.seguro.api.adapter.client;

import com.seguro.api.adapter.client.dto.ClienteDTO;
import com.seguro.api.domain.exceptions.ClienteNaoEncontradoException;
import com.seguro.api.domain.exceptions.ServiceNotFound;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteApiClient {

    private final RestTemplate restTemplate;

    public ClienteApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retry(name = "buscarCliente")
    @CircuitBreaker(name = "buscarCliente", fallbackMethod = "fallBackBuscarCliente")
    public ClienteDTO buscarClientePorId(Long idCliente) {
        String url = "http://localhost:8080/api/clientes/" + idCliente;
        return restTemplate.getForObject(url, ClienteDTO.class);
    }

    public ClienteDTO fallBackBuscarCliente(Long idCliente, Throwable ex) {
        if (ex instanceof HttpClientErrorException.NotFound) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }
        throw new ServiceNotFound("Serviço de Cliente está temporariamente indisponível.");
    }


}

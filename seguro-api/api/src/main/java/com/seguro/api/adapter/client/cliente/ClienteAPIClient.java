package com.seguro.api.adapter.client.cliente;

import com.seguro.api.adapter.client.dto.cliente.ClienteDTO;
import com.seguro.api.adapter.mapper.ClienteMapper;
import com.seguro.api.application.ports.ClienteApiPort;
import com.seguro.api.domain.exceptions.ClienteNaoEncontradoException;
import com.seguro.api.domain.exceptions.ServiceNotFound;
import com.seguro.api.domain.model.Cliente;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteAPIClient implements ClienteApiPort {

    private final RestTemplate restTemplate;
    private final ClienteMapper clienteMapper;

    @Value("${CLIENT-API-URL}")
    private String CLIENT_API_URL;

    public ClienteAPIClient(RestTemplate restTemplate, ClienteMapper clienteMapper) {
        this.restTemplate = restTemplate;
        this.clienteMapper = clienteMapper;
    }

    @Override
    @CircuitBreaker(name = "buscarCliente", fallbackMethod = "buscarClienteFallback")
    public Cliente buscarClientePorId(Long idCliente) {
        String url = CLIENT_API_URL + "/api/clientes/" + idCliente;
        try {
            ClienteDTO clienteDTO = restTemplate.getForObject(url, ClienteDTO.class);
            return clienteMapper.toDomain(clienteDTO);
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

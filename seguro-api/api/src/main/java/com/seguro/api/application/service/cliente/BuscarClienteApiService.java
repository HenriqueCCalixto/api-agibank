package com.seguro.api.application.service.cliente;

import com.seguro.api.adapter.client.cliente.ClienteAPIClient;
import com.seguro.api.adapter.client.dto.cliente.ClienteDTO;
import com.seguro.api.application.usecases.cliente.BuscarClienteUseCase;
import org.springframework.stereotype.Service;

@Service
public class BuscarClienteApiService implements BuscarClienteUseCase {

    private final ClienteAPIClient clienteApiClient;

    public BuscarClienteApiService(ClienteAPIClient clienteApiClient) {
        this.clienteApiClient = clienteApiClient;
    }

    @Override
    public ClienteDTO execute(Long idCliente) {
        return clienteApiClient.buscarClientePorId(idCliente);
    }
}

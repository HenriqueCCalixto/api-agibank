package com.seguro.api.application.service.cliente;

import com.seguro.api.adapter.client.ClienteApiClient;
import com.seguro.api.adapter.client.dto.ClienteDTO;
import com.seguro.api.application.usecases.cliente.BuscarClienteUseCase;
import org.springframework.stereotype.Service;

@Service
public class BuscarClienteApiService implements BuscarClienteUseCase {

    private final ClienteApiClient clienteApiClient;

    public BuscarClienteApiService(ClienteApiClient clienteApiClient) {
        this.clienteApiClient = clienteApiClient;
    }

    @Override
    public ClienteDTO execute(Long idCliente) {
        return clienteApiClient.buscarClientePorId(idCliente);
    }
}

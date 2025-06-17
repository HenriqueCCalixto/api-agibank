package com.seguro.api.application.service.cliente;

import com.seguro.api.application.ports.ClienteApiPort;
import com.seguro.api.application.usecases.cliente.BuscarClienteUseCase;
import com.seguro.api.domain.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class BuscarClienteApiService implements BuscarClienteUseCase {

    private final ClienteApiPort clienteApiPort;

    public BuscarClienteApiService(ClienteApiPort clienteApiPort) {
        this.clienteApiPort = clienteApiPort;
    }

    @Override
    public Cliente execute(Long idCliente) {
        return clienteApiPort.buscarClientePorId(idCliente);
    }
}

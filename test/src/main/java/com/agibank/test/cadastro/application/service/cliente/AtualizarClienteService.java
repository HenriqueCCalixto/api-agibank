package com.agibank.test.cadastro.application.service.cliente;

import com.agibank.test.cadastro.application.usecases.cliente.AtualizarClienteUseCase;
import com.agibank.test.cadastro.domain.entities.Cliente;
import com.agibank.test.cadastro.domain.repository.cliente.ClienteRepository;

public class AtualizarClienteService implements AtualizarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public AtualizarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}

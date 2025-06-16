package com.agibank.test.cadastro.application.service.cliente;

import com.agibank.test.cadastro.application.usecases.cliente.BuscarClienteUseCase;
import com.agibank.test.cadastro.domain.entities.Cliente;
import com.agibank.test.cadastro.domain.exceptions.ClienteNaoEncontradoException;
import com.agibank.test.cadastro.domain.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarClienteService implements BuscarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public BuscarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente execute(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + idCliente));
    }

}

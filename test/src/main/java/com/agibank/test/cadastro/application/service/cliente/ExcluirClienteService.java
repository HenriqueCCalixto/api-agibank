package com.agibank.test.cadastro.application.service.cliente;

import com.agibank.test.cadastro.application.usecases.cliente.ExcluirClienteUseCase;
import com.agibank.test.cadastro.domain.repository.cliente.ClienteRepository;

public class ExcluirClienteService implements ExcluirClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ExcluirClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void execute(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}

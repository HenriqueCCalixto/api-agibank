package com.agibank.test.cadastro.application.service.cliente;

import com.agibank.test.cadastro.application.usecases.cliente.CadastrarClienteUseCase;
import com.agibank.test.cadastro.domain.entities.Cliente;
import com.agibank.test.cadastro.domain.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarClienteService implements CadastrarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public CadastrarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}

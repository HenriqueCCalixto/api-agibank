package com.agibank.test.cadastro.domain.repository.cliente;

import com.agibank.test.cadastro.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
    void deleteById(Long id);
}

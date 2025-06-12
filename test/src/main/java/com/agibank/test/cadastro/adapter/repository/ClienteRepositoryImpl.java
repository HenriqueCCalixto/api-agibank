package com.agibank.test.cadastro.adapter.repository;

import com.agibank.test.cadastro.adapter.mapper.ClienteMapper;
import com.agibank.test.cadastro.domain.entities.Cliente;
import com.agibank.test.cadastro.domain.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryJpa clienteRepositoryJpa;
    private final ClienteMapper clienteMapper;

    public ClienteRepositoryImpl(ClienteRepositoryJpa clienteRepositoryJpa, ClienteMapper clienteMapper) {
        this.clienteRepositoryJpa = clienteRepositoryJpa;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        var entity = clienteMapper.toDataModel(cliente);
        var savedEntity = clienteRepositoryJpa.save(entity);
        return clienteMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepositoryJpa.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepositoryJpa.deleteById(id);
    }


}

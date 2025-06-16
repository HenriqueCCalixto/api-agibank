package com.agibank.test.cadastro.adapter.repository;

import com.agibank.test.cadastro.adapter.datamodel.cliente.ClienteDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepositoryJpa extends JpaRepository<ClienteDataModel, Long> {
    Optional<ClienteDataModel> findByCpf(String cpf);
}

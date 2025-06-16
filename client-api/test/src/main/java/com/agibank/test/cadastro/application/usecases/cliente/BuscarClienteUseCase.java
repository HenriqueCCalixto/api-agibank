package com.agibank.test.cadastro.application.usecases.cliente;

import com.agibank.test.cadastro.domain.entities.Cliente;

public interface BuscarClienteUseCase {
    Cliente execute(Long idCliente);
}

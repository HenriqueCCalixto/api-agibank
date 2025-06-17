package com.seguro.api.application.usecases.cliente;

import com.seguro.api.domain.model.Cliente;

public interface BuscarClienteUseCase {
    Cliente execute(Long idCliente);
}
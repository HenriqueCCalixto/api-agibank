package com.seguro.api.application.usecases.cliente;

import com.seguro.api.adapter.client.dto.ClienteDTO;

public interface BuscarClienteUseCase {
    ClienteDTO execute(Long idCliente);
}
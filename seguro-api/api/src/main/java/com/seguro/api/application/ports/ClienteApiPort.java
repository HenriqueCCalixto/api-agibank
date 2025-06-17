package com.seguro.api.application.ports;

import com.seguro.api.domain.model.Cliente;

public interface ClienteApiPort {
    Cliente buscarClientePorId(Long idCliente);
}

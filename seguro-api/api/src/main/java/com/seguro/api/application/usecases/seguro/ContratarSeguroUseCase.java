package com.seguro.api.application.usecases.seguro;

import com.seguro.api.domain.model.Seguro;

public interface ContratarSeguroUseCase {
    Seguro execute(Long idCliente);
}

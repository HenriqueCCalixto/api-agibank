package com.seguro.api.application.usecases.seguro;

import com.seguro.api.domain.enums.TipoSeguro;

public interface SimularSeguroUseCase {
    TipoSeguro execute(Long idCliente);
}

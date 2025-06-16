package com.seguro.api.application.service.seguro;

import com.seguro.api.application.usecases.seguro.SimularSeguroUseCase;
import com.seguro.api.domain.enums.TipoSeguro;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimularSeguroService implements SimularSeguroUseCase {

    private final Random random = new Random();

    @Override
    public TipoSeguro execute(Long idCliente) {
        TipoSeguro[] tipos = TipoSeguro.values();
        int index = random.nextInt(tipos.length);
        return tipos[index];
    }
}

package com.seguro.api.adapter.controller;

import com.seguro.api.application.usecases.seguro.ContratarSeguroUseCase;
import com.seguro.api.application.usecases.seguro.SimularSeguroUseCase;
import com.seguro.api.domain.enums.TipoSeguro;
import com.seguro.api.domain.model.Seguro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    private final SimularSeguroUseCase simularSeguroUseCase;
    private final ContratarSeguroUseCase contratarSeguroUseCase;

    public SeguroController(SimularSeguroUseCase simularSeguroUseCase, ContratarSeguroUseCase contratarSeguroUseCase) {
        this.simularSeguroUseCase = simularSeguroUseCase;
        this.contratarSeguroUseCase = contratarSeguroUseCase;
    }

    @GetMapping("/simular/{idCliente}")
    public ResponseEntity<TipoSeguro> simular(@PathVariable Long idCliente) {
        TipoSeguro tipoSeguro = simularSeguroUseCase.execute(idCliente);
        return ResponseEntity.ok(tipoSeguro);
    }

    @PostMapping("/contratar/{idCliente}")
    public ResponseEntity<Seguro> contratar(@PathVariable Long idCliente) {
        Seguro contratado = contratarSeguroUseCase.execute(idCliente);
        return ResponseEntity.ok(contratado);
    }

}

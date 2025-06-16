package com.seguro.api.application.service.seguro;

import com.seguro.api.application.usecases.cliente.BuscarClienteUseCase;
import com.seguro.api.application.usecases.seguro.ContratarSeguroUseCase;
import com.seguro.api.application.usecases.seguro.SimularSeguroUseCase;
import com.seguro.api.domain.enums.TipoSeguro;
import com.seguro.api.domain.model.Seguro;
import com.seguro.api.domain.repository.SeguroRepository;
import com.seguro.api.adapter.mapper.SeguroMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ContratarSeguroService implements ContratarSeguroUseCase {

    private final BuscarClienteUseCase buscarClienteUseCase;
    private final SimularSeguroUseCase simularSeguroUseCase;
    private final SeguroRepository seguroRepository;
    private final SeguroMapper seguroMapper;

    public ContratarSeguroService(BuscarClienteUseCase buscarClienteUseCase,
                                  SimularSeguroUseCase simularSeguroUseCase,
                                  SeguroRepository seguroRepository,
                                  SeguroMapper seguroMapper) {
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.simularSeguroUseCase = simularSeguroUseCase;
        this.seguroRepository = seguroRepository;
        this.seguroMapper = seguroMapper;
    }

    @Override
    public Seguro execute(Long idCliente) {
        var cliente = buscarClienteUseCase.execute(idCliente);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado. É necessário realizar o cadastro.");
        }

        TipoSeguro tipoSeguro = simularSeguroUseCase.execute(idCliente);

        Seguro seguro = new Seguro();
        seguro.setClienteId(idCliente);
        seguro.setTipoSeguro(tipoSeguro);
        seguro.setDataContratacao(LocalDate.now());
        seguro.setValor(definirValorSeguro(tipoSeguro));

        return seguroRepository.save(seguro);
    }

    private BigDecimal definirValorSeguro(TipoSeguro tipo) {
        return switch (tipo) {
            case BRONZE -> BigDecimal.valueOf(100.0);
            case PRATA -> BigDecimal.valueOf(200.0);
            case OURO -> BigDecimal.valueOf(300.0);
        };
    }
}

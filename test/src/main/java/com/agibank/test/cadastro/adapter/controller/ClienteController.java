package com.agibank.test.cadastro.adapter.controller;

import com.agibank.test.cadastro.adapter.dto.cliente.ClienteRequestDTO;
import com.agibank.test.cadastro.adapter.dto.cliente.ClienteResponseDTO;
import com.agibank.test.cadastro.adapter.mapper.ClienteMapper;
import com.agibank.test.cadastro.application.usecases.cliente.AtualizarClienteUseCase;
import com.agibank.test.cadastro.application.usecases.cliente.BuscarClienteUseCase;
import com.agibank.test.cadastro.application.usecases.cliente.CadastrarClienteUseCase;
import com.agibank.test.cadastro.application.usecases.cliente.ExcluirClienteUseCase;
import com.agibank.test.cadastro.domain.entities.Cliente;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final ExcluirClienteUseCase excluirClienteUseCase;
    private final ClienteMapper clienteMapper;

    public ClienteController(CadastrarClienteUseCase cadastrarClienteUseCase,
                             BuscarClienteUseCase buscarClienteUseCase,
                             AtualizarClienteUseCase atualizarClienteUseCase,
                             ExcluirClienteUseCase excluirClienteUseCase,
                             ClienteMapper clienteMapper) {
        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.atualizarClienteUseCase = atualizarClienteUseCase;
        this.excluirClienteUseCase = excluirClienteUseCase;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    public ClienteResponseDTO criar(@Valid @RequestBody ClienteRequestDTO requestDTO) {
        Cliente cliente = clienteMapper.toDomain(requestDTO);
        Cliente clienteSalvo = cadastrarClienteUseCase.execute(cliente);
        return clienteMapper.toResponseDTO(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscar(@PathVariable Long id) {
        Cliente cliente = buscarClienteUseCase.execute(id);
        return clienteMapper.toResponseDTO(cliente);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable Long id,
                                        @Valid @RequestBody ClienteRequestDTO request) {
        Cliente cliente = clienteMapper.toDomain(request);
        cliente.setId(id);
        Cliente clienteAtualizado = atualizarClienteUseCase.execute(cliente);
        return clienteMapper.toResponseDTO(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        excluirClienteUseCase.execute(id);
    }
}

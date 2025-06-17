package com.seguro.api.application.service.cliente;

import com.seguro.api.adapter.client.cliente.ClienteAPIClient;
import com.seguro.api.domain.exceptions.ClienteNaoEncontradoException;
import com.seguro.api.domain.exceptions.ServiceNotFound;
import com.seguro.api.domain.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarClienteApiServiceTest {

    private ClienteAPIClient clienteApiClient;
    private BuscarClienteApiService buscarClienteApiService;

    @BeforeEach
    void setUp() {
        clienteApiClient = mock(ClienteAPIClient.class);
        buscarClienteApiService = new BuscarClienteApiService(clienteApiClient);
    }

    @Test
    void deveRetornarClienteQuandoEncontrado() {
        Long idCliente = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        cliente.setNome("Cliente Teste");

        when(clienteApiClient.buscarClientePorId(idCliente)).thenReturn(cliente);

        Cliente resultado = buscarClienteApiService.execute(idCliente);

        assertNotNull(resultado);
        assertEquals(idCliente, resultado.getId());
        assertEquals("Cliente Teste", resultado.getNome());
        verify(clienteApiClient, times(1)).buscarClientePorId(idCliente);
    }

    @Test
    void deveLancarClienteNaoEncontradoExceptionQuandoClienteNaoExiste() {
        Long idCliente = 2L;

        when(clienteApiClient.buscarClientePorId(idCliente))
                .thenThrow(new ClienteNaoEncontradoException("Cliente não encontrado."));

        ClienteNaoEncontradoException exception = assertThrows(
                ClienteNaoEncontradoException.class,
                () -> buscarClienteApiService.execute(idCliente)
        );

        assertEquals("Cliente não encontrado.", exception.getMessage());
        verify(clienteApiClient, times(1)).buscarClientePorId(idCliente);
    }

    @Test
    void deveLancarServiceNotFoundQuandoServicoIndisponivel() {
        Long idCliente = 3L;

        when(clienteApiClient.buscarClientePorId(idCliente))
                .thenThrow(new ServiceNotFound("Serviço de Cliente está temporariamente indisponível."));

        ServiceNotFound exception = assertThrows(
                ServiceNotFound.class,
                () -> buscarClienteApiService.execute(idCliente)
        );

        assertEquals("Serviço de Cliente está temporariamente indisponível.", exception.getMessage());
        verify(clienteApiClient, times(1)).buscarClientePorId(idCliente);
    }
}

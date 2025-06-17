package com.seguro.api.adapter.mapper;

import com.seguro.api.adapter.client.dto.cliente.ClienteDTO;
import com.seguro.api.domain.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toDomain(ClienteDTO clienteDTO);

}

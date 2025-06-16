package com.agibank.test.cadastro.adapter.mapper;

import com.agibank.test.cadastro.adapter.datamodel.cliente.ClienteDataModel;
import com.agibank.test.cadastro.adapter.dto.cliente.ClienteRequestDTO;
import com.agibank.test.cadastro.adapter.dto.cliente.ClienteResponseDTO;
import com.agibank.test.cadastro.domain.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toDomain(ClienteDataModel clienteDataModel);

    ClienteDataModel toDataModel(Cliente cliente);

    Cliente toDomain(ClienteRequestDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente cliente);
}

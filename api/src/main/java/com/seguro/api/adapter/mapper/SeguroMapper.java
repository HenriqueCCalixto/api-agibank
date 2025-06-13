package com.seguro.api.adapter.mapper;

import com.seguro.api.adapter.datamodel.SeguroDataModel;
import com.seguro.api.domain.model.Seguro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeguroMapper {

    SeguroMapper INSTANCE = Mappers.getMapper(SeguroMapper.class);

    SeguroDataModel toDataModel(Seguro seguro);

    Seguro toDomain(SeguroDataModel seguroDataModel);
}


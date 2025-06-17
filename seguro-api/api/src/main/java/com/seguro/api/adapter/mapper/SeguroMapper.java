package com.seguro.api.adapter.mapper;

import com.seguro.api.adapter.datamodel.SeguroDataModel;
import com.seguro.api.domain.model.Seguro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeguroMapper {

    SeguroDataModel toDataModel(Seguro seguro);

    Seguro toDomain(SeguroDataModel seguroDataModel);
}


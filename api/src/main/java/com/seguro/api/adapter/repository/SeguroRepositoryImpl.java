package com.seguro.api.adapter.repository;

import com.seguro.api.adapter.datamodel.SeguroDataModel;
import com.seguro.api.adapter.mapper.SeguroMapper;
import com.seguro.api.domain.model.Seguro;
import com.seguro.api.domain.repository.SeguroRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SeguroRepositoryImpl implements SeguroRepository {

   private final SeguroRepositoryJpa seguroRepositoryJpa;
   private final SeguroMapper seguroMapper;

    public SeguroRepositoryImpl(SeguroRepositoryJpa seguroRepositoryJpa, SeguroMapper seguroMapper) {
        this.seguroRepositoryJpa = seguroRepositoryJpa;
        this.seguroMapper = seguroMapper;
    }

    @Override
    public Seguro save(Seguro seguro) {
        SeguroDataModel dataModel = seguroMapper.toDataModel(seguro);
        SeguroDataModel saved = seguroRepositoryJpa.save(dataModel);
        return seguroMapper.toDomain(saved);
    }

    @Override
    public Optional<Seguro> findById(Long id) {
        Optional<SeguroDataModel> dataModelOptional = seguroRepositoryJpa.findById(id);
        return dataModelOptional.map(seguroMapper::toDomain);
    }
}

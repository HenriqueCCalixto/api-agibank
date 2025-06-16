package com.seguro.api.domain.repository;

import com.seguro.api.domain.model.Seguro;

import java.util.Optional;

public interface SeguroRepository {
    Seguro save(Seguro seguro);
    Optional<Seguro> findById(Long id);
}

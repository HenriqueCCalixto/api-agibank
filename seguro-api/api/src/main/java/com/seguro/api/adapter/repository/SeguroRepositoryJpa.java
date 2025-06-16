package com.seguro.api.adapter.repository;

import com.seguro.api.adapter.datamodel.SeguroDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepositoryJpa extends JpaRepository<SeguroDataModel, Long> {
}

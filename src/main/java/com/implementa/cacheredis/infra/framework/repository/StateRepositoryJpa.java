package com.implementa.cacheredis.infra.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementa.cacheredis.infra.framework.model.StateEntity;

public interface StateRepositoryJpa extends JpaRepository<StateEntity, Long>{
    
}

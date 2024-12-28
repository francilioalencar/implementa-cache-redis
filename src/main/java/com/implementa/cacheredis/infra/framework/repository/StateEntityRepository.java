package com.implementa.cacheredis.infra.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementa.cacheredis.infra.framework.model.StateEntity;

public interface StateEntityRepository extends JpaRepository<StateEntity, Long>{
    
}

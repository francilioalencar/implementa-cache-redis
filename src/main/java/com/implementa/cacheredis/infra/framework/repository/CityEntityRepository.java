package com.implementa.cacheredis.infra.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementa.cacheredis.infra.framework.model.CityEntity;

public interface CityEntityRepository extends JpaRepository<CityEntity, Long>{
    
}

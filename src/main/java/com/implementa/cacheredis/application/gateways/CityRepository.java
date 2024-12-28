package com.implementa.cacheredis.application.gateways;

import java.util.List;

import com.implementa.cacheredis.domain.entity.city.City;

public interface CityRepository {
    
    City saveInJpa(City city);
    City findByIdInJpa(Long id);
    List<City> findAllInJpa();
    

}

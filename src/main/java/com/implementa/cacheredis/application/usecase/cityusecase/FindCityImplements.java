package com.implementa.cacheredis.application.usecase.cityusecase;

import java.util.List;

import com.implementa.cacheredis.application.gateways.CityRepository;
import com.implementa.cacheredis.domain.entity.city.City;

public class FindCityImplements implements FindCity{

    private final CityRepository cityRepository;

    public FindCityImplements(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> useCaseFindAllCity() {
        
        return this.cityRepository.findAllInJpa();

    }

    @Override
    public City useCaseFindACityById(Long id) {
        
        return this.cityRepository.findByIdInJpa(id);
    }
    
}

package com.implementa.cacheredis.application.usecase.cityusecase;

import com.implementa.cacheredis.application.gateways.CityRepository;
import com.implementa.cacheredis.domain.entity.city.City;

public class SaveCityImplements implements SaveCity{

    
    private final CityRepository cityRepository;

    public SaveCityImplements(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public City useCaseSave(City city) {
        
        return this.cityRepository.saveInJpa(city);

    }
    
}

package com.implementa.cacheredis.application.usecase.cityusecase;

import java.util.List;

import com.implementa.cacheredis.domain.entity.city.City;

public interface FindCity {


    List<City> useCaseFindAllCity();
    City useCaseFindACityById(Long id);
    
    
}

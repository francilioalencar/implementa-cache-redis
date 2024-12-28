package com.implementa.cacheredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.implementa.cacheredis.application.gateways.CityRepository;
import com.implementa.cacheredis.application.usecase.cityusecase.FindCityImplements;
import com.implementa.cacheredis.application.usecase.cityusecase.SaveCityImplements;

@Configuration

public class CityConfig {
    

    @Bean
    FindCityImplements findCityImplements(CityRepository cityRepository){
        return new FindCityImplements(cityRepository);
    }

    @Bean
    SaveCityImplements saveCityImplements(CityRepository cityRepository){
        return new SaveCityImplements(cityRepository);
    }


}

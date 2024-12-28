package com.implementa.cacheredis.domain.entity.city;

import com.implementa.cacheredis.domain.entity.state.State;
import com.implementa.cacheredis.infra.framework.model.CityEntity;

public class CityBuilder {
    
    private City city;

    public City cityBuilder(String description, String zipCode){

        city =  new City();
        city.setDescription(description);
        city.setZipCode(zipCode);

        return city;

    }
    
    public City cityBuilderWithState(String description, String zipCode, Long stateId){

        city =  new City();
        city.setDescription(description);
        city.setZipCode(zipCode);
        city.setStateId(stateId);

        return city;

    }

    public City cityByCityEntity(CityEntity cityEntity){

        city =  new City();
        city.setId(cityEntity.getId());
        city.setDescription(cityEntity.getDescription());
        city.setZipCode(cityEntity.getZipCode());
        city.setStateId(cityEntity.getStateEntity().getId());

        return city;

    }


}

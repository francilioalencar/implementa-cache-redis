package com.implementa.cacheredis.domain.entity.city;

import com.implementa.cacheredis.domain.entity.state.State;

public class City {
    
    private Long id;
    private String description;
    private String zipCode;
    private Long stateId;

    public Long getStateId() {
        return stateId;
    }
    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


}

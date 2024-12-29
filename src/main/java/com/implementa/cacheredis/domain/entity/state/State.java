package com.implementa.cacheredis.domain.entity.state;

import java.io.Serializable;

public class State implements Serializable {
    

    private Long id;
    private String description;
    private String acronym;

    
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
    public String getAcronym() {
        return acronym;
    }
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }


    
}

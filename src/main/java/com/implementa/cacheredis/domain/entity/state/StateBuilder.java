package com.implementa.cacheredis.domain.entity.state;

public class StateBuilder {
    

    private State estado;

    public State EstadoBuilder(String description, String acronym){
        this.estado = new State();
        estado.setDescription(description);
        estado.setAcronym(acronym);
        
        return this.estado;
    }
    public State EstadoBuilderId(Long id, String description, String acronym){
        this.estado = new State();
        estado.setId(id);
        estado.setDescription(description);
        estado.setAcronym(acronym);
        
        return this.estado;
    }


}

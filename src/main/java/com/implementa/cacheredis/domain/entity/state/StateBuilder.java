package com.implementa.cacheredis.domain.entity.state;

public class StateBuilder {
    

    private State estado;

    public State EstadoBuilder(String descricao, String sigla){
        this.estado = new State();
        estado.setDescricao(descricao);
        estado.setSigla(sigla);
        
        return this.estado;
    }
    public State EstadoBuilderId(Long id, String descricao, String sigla){
        this.estado = new State();
        estado.setId(id);
        estado.setDescricao(descricao);
        estado.setSigla(sigla);
        
        return this.estado;
    }


}

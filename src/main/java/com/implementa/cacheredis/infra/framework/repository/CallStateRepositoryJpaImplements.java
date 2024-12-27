package com.implementa.cacheredis.infra.framework.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.implementa.cacheredis.application.gateways.CallStateRepositoryJpa;
import com.implementa.cacheredis.domain.entity.state.State;
import com.implementa.cacheredis.domain.entity.state.StateBuilder;
import com.implementa.cacheredis.infra.framework.model.StateEntity;

@Service
public class CallStateRepositoryJpaImplements implements CallStateRepositoryJpa {


    private final StateRepositoryJpa stateRepositoryJpa;

    public CallStateRepositoryJpaImplements(StateRepositoryJpa stateRepositoryJpa){
        this.stateRepositoryJpa = stateRepositoryJpa;
    }

    @Override
    public State saveInJpa(State state) {
        

        StateEntity stateEntity = StateEntity.builder().descricao(state.getDescricao()).sigla(state.getSigla()).build();

        this.stateRepositoryJpa.save(stateEntity);

        return new StateBuilder().EstadoBuilderId(stateEntity.getId(), stateEntity.getDescricao(), stateEntity.getSigla() );

    }

    @Override
    public List<State> findAllInJpa() {
        // TODO Auto-generated method stub
       
        List<State> states = new ArrayList<>();

        this.stateRepositoryJpa.findAll().forEach(item->{
            states.add( new StateBuilder().EstadoBuilderId(item.getId(), item.getDescricao(), item.getSigla()) );
       });

       return states;
    }

    @Override
    public State findByIdInJpa(Long id) {

        StateEntity entity = this.stateRepositoryJpa.findById(id).orElseThrow(NoSuchElementException::new);
        
         return new StateBuilder().EstadoBuilderId(entity.getId(), entity.getDescricao(), entity.getSigla());

    }
    
}

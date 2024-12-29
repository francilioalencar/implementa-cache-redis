package com.implementa.cacheredis.infra.framework.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.implementa.cacheredis.application.gateways.StateRepository;
import com.implementa.cacheredis.domain.entity.state.State;
import com.implementa.cacheredis.domain.entity.state.StateBuilder;
import com.implementa.cacheredis.infra.framework.model.StateEntity;

@Service
public class StateRepositoryImplements implements StateRepository {


    private final StateEntityRepository stateEntityRepository;

    public StateRepositoryImplements(StateEntityRepository stateEntityRepository){
        this.stateEntityRepository = stateEntityRepository;
    }

    @CacheEvict(value = "useCaseFindAllState", allEntries = true)
    @Override
    public State saveInJpa(State state) {
        

        StateEntity stateEntity = StateEntity.builder().description(state.getDescription()).acronym(state.getAcronym()).build();

        this.stateEntityRepository.save(stateEntity);

        return new StateBuilder().EstadoBuilderId(stateEntity.getId(), stateEntity.getDescription(), stateEntity.getAcronym() );

    }

    
    @Override
    @Cacheable(value = "useCaseFindAllState")
    public List<State> findAllInJpa() {
        // TODO Auto-generated method stub
       
        List<State> states = new ArrayList<>();

        this.stateEntityRepository.findAll().forEach(item->{
            states.add( new StateBuilder().EstadoBuilderId(item.getId(), item.getDescription(), item.getAcronym()) );
       });

       return states;
    }

    @Override
    public State findByIdInJpa(Long id) {

        StateEntity entity = this.stateEntityRepository.findById(id).orElseThrow(NoSuchElementException::new);
        
         return new StateBuilder().EstadoBuilderId(entity.getId(), entity.getDescription(), entity.getAcronym());

    }
    
}

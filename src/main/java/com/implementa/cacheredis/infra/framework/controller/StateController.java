package com.implementa.cacheredis.infra.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementa.cacheredis.application.usecase.FindState;
import com.implementa.cacheredis.application.usecase.SaveState;
import com.implementa.cacheredis.domain.entity.state.State;
import com.implementa.cacheredis.domain.entity.state.StateBuilder;
import com.implementa.cacheredis.infra.dto.StateDtoPost;


@RestController
@RequestMapping("/v1/state")
public class StateController {


    private final FindState findState;

    private final SaveState saveState;

    @Autowired
    public StateController(FindState findState, SaveState saveState){
        this.findState = findState;
        this.saveState = saveState;
    }


    
    @PostMapping
    public ResponseEntity  saveState(@RequestBody StateDtoPost stateDtoPost){
        return ResponseEntity.ok(  this.saveState.saveState(new StateBuilder().EstadoBuilder(stateDtoPost.descricao(), stateDtoPost.sigla()) ) );
    }
    


    @GetMapping
     public ResponseEntity<List<State>> findAllState() {
        return ResponseEntity.ok(this.findState.useCaseFindAll());
    }

    @GetMapping("{id}")
     public ResponseEntity<State> findById( @PathVariable Long id) {
        return ResponseEntity.ok(this.findState.useCaseFindById(id));
    }

}

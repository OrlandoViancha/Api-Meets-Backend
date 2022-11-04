package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Act;
import edu.uptc.apirest.repositories.ActRepository;

@Service
public class ActService {

    private ActRepository actRepository;
        
    public ActService(ActRepository actRepository){

        this.actRepository = actRepository;
    }


    public List<Act> getActs(){
        
        return actRepository.findAll();
    }
    public Act addAct(Act act){

        return actRepository.save(act);
    }

    public Act deleteAct(int id){

        Act act= findById( id );

        if(act!=null){

            actRepository.delete(act);
        }

        return act;
    }

    public Act findById(int id){

        Optional<Act> optAct = actRepository.findById(id);

        return optAct.isPresent() ? optAct.get() : null;
    }
    
}

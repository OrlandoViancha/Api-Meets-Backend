package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Meet;
import edu.uptc.apirest.repositories.MeetRepository;

@Service
public class MeetService {

    private MeetRepository meetRepository;


    public MeetService(MeetRepository meetRepository){

        this.meetRepository = meetRepository;
    }

    public Meet addMeet(Meet meet){

        return meetRepository.save(meet);
    }

    public Meet findById(int id){

        Optional<Meet> optMeet= meetRepository.findById(id);

        return optMeet.isPresent() ? optMeet.get():null;
    }

    public List<Meet> getMeets(){

        return meetRepository.findAll();
    }

    public Meet putMeet(Meet meet){

        if(findById( meet.getId()) !=  null ){

            return meetRepository.save(meet);
        }

        return null;
    }

    public Meet DeleteMeet(int id){

        Meet meet=findById(id);

        if(meet != null ){

            meetRepository.delete(meet);
        }
        return meet;
    }
    
}

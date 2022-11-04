package edu.uptc.apirest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.apirest.entities.Meet;
import edu.uptc.apirest.services.MeetService;


@RestController
@RequestMapping(value="/meets")
public class MeetController {

    private MeetService meetService;

    public MeetController(MeetService meetService) {
        this.meetService = meetService;
    } 

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping

    public List<Meet> getMeetList(){

        return meetService.getMeets();
    }

  
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping

    public Meet addMeet(@RequestBody Meet meet){

        try {

            return meetService.addMeet(meet);
            
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

        
        
    }

    @PutMapping("/")

    public Meet putMeet(@RequestBody Meet meet){

        return meetService.putMeet(meet);
    }

    @CrossOrigin(origins = "http://localhost:3000") 
    @DeleteMapping("/{id}")

    public Meet deleteMeet(@PathVariable int id){

        return meetService.DeleteMeet(id); 
    }
    
}

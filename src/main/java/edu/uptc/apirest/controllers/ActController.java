package edu.uptc.apirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.uptc.apirest.entities.Act;
import edu.uptc.apirest.services.ActService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/acts")
public class ActController {
    
    private ActService actService;

    public ActController(ActService actService) {

        this.actService = actService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping

    public List<Act> getActs(){
        return actService.getActs();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    
    public Act addAct(@RequestBody Act act){

        return actService.addAct(act);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")

    public Act deleteAct(@PathVariable int id){
        return actService.deleteAct(id);
    }
    
    
}

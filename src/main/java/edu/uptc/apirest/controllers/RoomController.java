package edu.uptc.apirest.controllers;

import edu.uptc.apirest.entities.Room;
import edu.uptc.apirest.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rooms")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getRooms")
    public List<Room> getRooms(){

        return roomService.getRooms();

    }

    @GetMapping("/{id}")
    public Room findById( @PathVariable Integer id){

       return roomService.findById( id );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addRoom")
    public Room save( @RequestBody Room room ){

        System.out.println(room.getDescription());
        return roomService.save( room );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public Room update( @RequestBody Room room, @PathVariable int id){

       return roomService.update( room );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public Room delete( @PathVariable int id ){

        return roomService.delete(id); 
    }
}

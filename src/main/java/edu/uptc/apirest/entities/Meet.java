package edu.uptc.apirest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meets")
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false, length = 255)
    private String affair;

    @Column(name = "date_meet", nullable = false)
    private LocalDate dateMeet;

    @OneToOne(mappedBy = "meet")
    @JsonIgnoreProperties(value="meet")
    private Act act;
     

    @ManyToOne( fetch = FetchType.LAZY )
    private Room room;

    public Meet() {
    }

    public Meet(String affair, LocalDate dateMeet, Room room) {
        this.affair = affair;
        this.dateMeet = dateMeet;
        this.room = room;
        room.addMeet( this );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public LocalDate getDateMeet() {
        return dateMeet;
    }

    public void setDateMeet(LocalDate dateMeet) {
        this.dateMeet = dateMeet;
    } 

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "id=" + id +
                ", affair='" + affair + '\'' +
                ", dateMeet=" + dateMeet +
                ", room= " +room + "\n" +
                '}';
    }
}
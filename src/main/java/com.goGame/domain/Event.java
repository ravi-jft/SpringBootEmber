package com.goGame.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ravi on 27/6/17.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable{
    private static final long serialVersionUID = 145863808199176136L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description",unique = true)
    private String description;

    public Event(){}

    public Event(String name,String description){
        this.name=name;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.goGame.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.goGame.domain.Event;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by ravi on 27/6/17.
 */
@Entity
@Table(name = "dataparam")
@JsonRootName(value = "data")
public class Dataparam implements Serializable {

    private static final long serialVersionUID = 145863808125176136L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private Event attributes;

    public Dataparam() {
    }

    public Dataparam(String type,Event attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public Dataparam(String type,Long id,Event attributes) {
        this.type = type;
        this.id=id;
        this.attributes = attributes;
    }

    public Event getAttributes() {
        return attributes;
    }

    public void setAttributes(Event attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
    }
}




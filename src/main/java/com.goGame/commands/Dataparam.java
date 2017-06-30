package com.goGame.commands;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.goGame.domain.Attribute;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ravi on 27/6/17.
 */
@JsonRootName(value = "data")
public class Dataparam  {

  //  private String id;
  private Attribute attributes;
    private String type;




 /*   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/


    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}




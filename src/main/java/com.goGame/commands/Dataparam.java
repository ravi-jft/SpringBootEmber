package com.goGame.commands;


import com.goGame.domain.Attribute;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ravi on 27/6/17.
 */
@Configuration
@JsonRootName(value = "data")
public class Dataparam {
    private String id;
    private String type;
    private Attribute attribute;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}

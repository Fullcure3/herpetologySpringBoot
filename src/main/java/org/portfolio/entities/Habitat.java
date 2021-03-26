package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "habitat_id")
@Entity
@Table(name = "habitats")
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitat_id;
    private String type;
    private String description;

    @OneToMany(mappedBy = "habitat", fetch = FetchType.EAGER)
    private List<HerpHabitats> herpHabitats;
    public Habitat() {
    }

    public int getHabitat_id() {
        return habitat_id;
    }

    public void setHabitat_id(int habitat_id) {
        this.habitat_id = habitat_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<HerpHabitats> getHerpHabitats() {
        return herpHabitats;
    }

    public void setHerpHabitats(List<HerpHabitats> herpHabitats) {
        this.herpHabitats = herpHabitats;
    }

}

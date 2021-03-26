package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "habitatId")
@Entity
@Table(name = "habitats")
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitat_id")
    private int habitatId;
    private String type;
    private String description;

    @OneToMany(mappedBy = "habitat", fetch = FetchType.EAGER)
    private List<HerpHabitats> herpHabitats;
    public Habitat() {
    }

    public int getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(int habitat_id) {
        this.habitatId = habitat_id;
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

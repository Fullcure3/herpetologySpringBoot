package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "genus_id")
@Entity
@Table(name = "genuses")
public class Genus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genus_id;
    private String genus;

    @OneToMany(mappedBy = "genus")
    private List<Classification> classifications;

    public Genus() {
    }

    public int getGenus_id() {
        return genus_id;
    }

    public void setGenus_id(int genus_id) {
        this.genus_id = genus_id;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }
}

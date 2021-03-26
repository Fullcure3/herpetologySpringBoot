package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "genusId")
@Entity
@Table(name = "genuses")
public class Genus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genus_id")
    private int genusId;
    private String genus;

    @JsonIgnore
    @OneToMany(mappedBy = "genus")
    private List<Classification> classifications;

    public Genus() {
    }

    public int getGenusId() {
        return genusId;
    }

    public void setGenusId(int genus_id) {
        this.genusId = genus_id;
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

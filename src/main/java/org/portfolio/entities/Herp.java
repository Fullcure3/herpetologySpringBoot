package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "herpId")
@Entity
@Table(name = "herps")
public class Herp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "herp_id")
    private int herpId;
    @Column(name = "common_name")
    private String commonName;
    @Column(name = "mating_ritual")
    private String matingRitual;

    @OneToOne
    @JoinColumn(name = "classification_id")
    private Classification classification;

    @OneToMany(mappedBy = "herp", fetch = FetchType.EAGER)
    private List<HerpHabitats> herpHabitats;

    public Herp() {
    }

    public int getHerpId() {
        return herpId;
    }

    public void setHerpId(int herp_id) {
        this.herpId = herp_id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getMatingRitual() {
        return matingRitual;
    }

    public void setMatingRitual(String matingRitual) {
        this.matingRitual = matingRitual;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public List<HerpHabitats> getHerpHabitats() {
        return herpHabitats;
    }

    public void setHerpHabitats(List<HerpHabitats> herpHabitats) {
        this.herpHabitats = herpHabitats;
    }
}

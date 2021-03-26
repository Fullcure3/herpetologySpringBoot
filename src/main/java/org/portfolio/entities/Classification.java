package org.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "classificationId")
@Entity
@Table(name = "classifications")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classification_id")
    private int classificationId;
    private String species;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private HerpClass herpClass;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne
    @JoinColumn(name = "genus_id")
    private Genus genus;

    public Classification() {
    }

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classification_id) {
        this.classificationId = classification_id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public HerpClass getHerpClass() {
        return herpClass;
    }

    public void setHerpClass(HerpClass class_id) {
        this.herpClass = class_id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family_id) {
        this.family = family_id;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus_id) {
        this.genus = genus_id;
    }


}

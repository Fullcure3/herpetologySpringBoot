package org.portfolio.entities;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classification_id;
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

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
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

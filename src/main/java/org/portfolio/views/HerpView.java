package org.portfolio.views;

import javax.persistence.*;

@Entity
@Table(name = "herpetology_webpage")
public class HerpView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "herp_id")
    private int herpID;
    @Column(name = "common_name")
    private String commonName;
    @Column(name = "class")
    private String herpClass;
    private String family;
    private String genus;
    private String species;
    private String type;

    public HerpView() {
    }

    public int getHerpID() {
        return herpID;
    }

    public void setHerpID(int herpID) {
        this.herpID = herpID;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getHerpClass() {
        return herpClass;
    }

    public void setHerpClass(String herpClass) {
        this.herpClass = herpClass;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Herp{" +
                "commonName='" + commonName + '\'' +
                '}';
    }
}

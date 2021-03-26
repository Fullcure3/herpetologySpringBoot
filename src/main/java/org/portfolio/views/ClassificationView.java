package org.portfolio.views;

import javax.persistence.*;

@Entity
@Table(name = "herps_with_classifications")
public class ClassificationView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "herp_id")
    private int herpId;
    @Column(name = "common_name")
    private String commonName;
    @Column(name = "class")
    private String classes;
    private String family;
    private String genus;
    private String species;

    public ClassificationView() {
    }

    public int getHerpId() {
        return herpId;
    }

    public void setHerpId(int herpId) {
        this.herpId = herpId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
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
}

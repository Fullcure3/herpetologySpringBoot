package org.portfolio.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "herps_habitats")
public class HerpHabitats implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int herp_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitat_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "herp_id")
    private Herp herp;

    public HerpHabitats() {
    }

    public int getHerp_id() {
        return herp_id;
    }

    public void setHerp_id(int herp_id) {
        this.herp_id = herp_id;
    }

    public int getHabitat_id() {
        return habitat_id;
    }

    public void setHabitat_id(int habitat_id) {
        this.habitat_id = habitat_id;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Herp getHerp() {
        return herp;
    }

    public void setHerp(Herp herp) {
        this.herp = herp;
    }

}

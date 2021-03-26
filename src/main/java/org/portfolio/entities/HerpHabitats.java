package org.portfolio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "herps_habitats")
public class HerpHabitats implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "herp_id")
    private int herpId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitat_id")
    private int habitatId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "herp_id")
    private Herp herp;

    public HerpHabitats() {
    }

    public int getHerpId() {
        return herpId;
    }

    public void setHerpId(int herp_id) {
        this.herpId = herp_id;
    }

    public int getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(int habitat_id) {
        this.habitatId = habitat_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerpHabitats that = (HerpHabitats) o;
        return herpId == that.herpId && habitatId == that.habitatId && habitat.equals(that.habitat) && herp.equals(that.herp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(herpId, habitatId, habitat, herp);
    }
}

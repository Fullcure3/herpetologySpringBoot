package org.portfolio.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class HerpClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;
    @Column(name = "class")
    private String className;

    @OneToMany(mappedBy = "herpClass")
    List<Classification> classifications;
    public HerpClass() {
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }
}

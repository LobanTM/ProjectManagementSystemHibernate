package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill implements Serializable {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "skill")
    private  String nameSkill;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private List<Developer> developers;

    public Skill() {
    }

    public Skill(int id, String nameSkill) {
        this.id = id;
        this.nameSkill = nameSkill;
    }

    public Skill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return nameSkill ;
    }
}
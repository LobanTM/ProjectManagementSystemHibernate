package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="companies")
public class Company implements Serializable {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company")
    private  String nameCompany;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Developer> developers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Project> projects;

    public Company() {
    }

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return  id +
                ", " + nameCompany ;
    }
}

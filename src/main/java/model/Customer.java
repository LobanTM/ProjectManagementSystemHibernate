package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer")
    private  String nameCustomer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Project> projects;

    public Customer() {
    }

    public Customer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return id +
                ", " + nameCustomer;
    }
}

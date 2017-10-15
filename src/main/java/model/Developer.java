package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="developers")
public class Developer implements Serializable {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_dev")
    private String nameDeveloper;
    @Column(name="age")
    private int age;
    @Column(name="email")
    private String email;
    @Column(name="salary")
    private Float salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private List<Skill> skills;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private List<Project> projects;

    public Developer() {
    }

    public Developer(String nameDeveloper, int age) {
        this.nameDeveloper = nameDeveloper;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDeveloper() {
        return nameDeveloper;
    }

    public void setNameDeveloper(String nameDeveloper) {
        this.nameDeveloper = nameDeveloper;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        String sSkills = "";
        for (Skill s: skills) {sSkills += ", "+s;}
        String sProjects = "";
        //for (Project p: projects){sProjects += ", " + p.getProject();}

        return "Developer{" +
                id +
                ", name:'" + nameDeveloper + '\'' +
                ", age:" + age +
//                ", email:'" + email + '\'' +
                ", salary:" + salary +
                ", company:" + company +
                ","+'\n' +
                " skills:" + sSkills +//'\n' +
//                ", projects=" + sProjects +
                '}';
    }

}

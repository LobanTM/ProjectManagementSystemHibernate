package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="projects")
public class Project implements Serializable {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project")
    private String project;

    @Column(name = "cost")
    private float cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private List<Developer> developers;

    public Project() {
    }

    public Project(String project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        String sDevelopers = "";
        //for(Developer d: developers){sDevelopers += ", " + d.getNameDeveloper();}
        return "Project{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", cost=" + cost +
                ", company=" + company +
                ", customer=" + customer +//'\n' +
//                ", developers=" + sDevelopers +
                '}';
    }
}
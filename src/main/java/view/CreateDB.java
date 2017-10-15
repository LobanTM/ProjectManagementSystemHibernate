package view;

import dao.*;
import model.*;

import java.util.List;

public class CreateDB {

    public void createFullDB(){
        //createDB();

        findAllSkillsWithDevelopers();
        System.out.println("=====================");

        findAllCompanies();
        System.out.println("=====================");

        findAllCustomer();
        System.out.println("=====================");

        findAllDevelopers();
        System.out.println("=====================");

        findAllProjects();

//        createCompany();
//        findAllCompanies();

//        createCustomer();
//        findAllCustomer();

//        createDeveloper();

//        findAllSkillsWithDevelopers();
//        findAllDevelopers();

//        createProject();
//        findAllProjects();
//        System.out.println("=====================");
//        findAllDevelopers();
    }

    private static void createDB(){
        createSkill("JaVa");
        createSkill("C++");
        createSkill("html");
        createSkill("cSS");
        createSkill("Python");
        createSkill("Andriod");
        createSkill("SQL");
        createSkill("Hibernate");
        createSkill("Spring");
        createSkill("Servlet");

        createCompany("IBM");
        createCompany("ABB");
        createCompany("Luxoft");
        createCompany("Cyclum");
        createCompany("Metr");
        createCompany("MicroSoft");
        createCompany("Intel");

        createCustomer("Utel");
        createCustomer("Ariston");
        createCustomer("WOG");
        createCustomer("Inter");
        createCustomer("Boots");
        createCustomer("Indesit");
        createCustomer("Vitek");
        createCustomer("Brother");
        createCustomer("CFX");
        createCustomer("OKKO");

        createDeveloper("Tim Taller", 25, 1);
        createDeveloper("Tom Crouse", 25, 3);
        createDeveloper("Barac Obama", 25, 5);
        createDeveloper("Black", 25, 2);
        createDeveloper("Billy Bons", 25, 3);
        createDeveloper("Jame Lanister", 25, 4);
        createDeveloper("Jonh Snow", 25, 5);
        createDeveloper("Peter Pen", 25, 3);
        createDeveloper("Mr Snek", 25, 2);
        createDeveloper("Lincoln2", 25, 6);
        createDeveloper("Lincoln3", 25, 1);
        createDeveloper("Lincoln4", 25, 1);
        createDeveloper("Lincoln5", 25, 3);

        createProject("Project01", 3);
        createProject("Project02", 4);
        createProject("Project03", 1);
        createProject("Project04", 2);
        createProject("Project05", 3);
        createProject("Project06", 5);
        createProject("Project07", 6);
        createProject("Project08", 6);
        createProject("Project09", 2);
        createProject("Project10", 1);
        createProject("Project11", 1);
        createProject("Project12", 3);
        createProject("Project13", 4);
        createProject("Project14", 2);
        createProject("Project15", 6);
        createProject("Project16", 3);
    }

    public static void createCustomer(String name){
        Customer customer = new Customer(name);
        CustomerDAO.create(customer);
    }

    public static void createSkill(String name){
        Skill skill = new Skill(name);
        SkillDAO.create(skill);
    }

    public static void createDeveloper(String name, int age, int number){
        Developer developer = new Developer(name, age);
        List<Skill> skills = SkillDAO.findAll();
        developer.setSkills(skills);
        List<Company> companies = CompanyDAO.findAll();
        developer.setCompany(companies.get(number));
        DeveloperDAO.create(developer);
    }

    public static void createCompany(String name){
        Company company = new Company(name);
        CompanyDAO.create(company);
    }

    public static void createProject(String name, int number){
        Project project = new Project(name);
        List<Company> companies = CompanyDAO.findAll();
        project.setCompany(companies.get(number));
        List<Customer> customers = CustomerDAO.findAll();
        project.setCustomer(customers.get(number));
        ProjectDAO.create(project);
    }

    public static void findAllProjects(){
        for(Project p : ProjectDAO.findAll()){
            System.out.println(p);
        }
    }

    public static void findAllSkillsWithDevelopers(){
        for (Skill s: SkillDAO.findAll()) {
            System.out.print(s.getNameSkill()+" ");
            for (Developer d : s.getDevelopers()) {
                System.out.print(d.getNameDeveloper()+ ", ");
            }
            System.out.println();
        }
    }

    public static void findAllDevelopers(){
        for (Developer d: DeveloperDAO.findAll()) {
            System.out.println(d);
        }
    }

    public static void findAllCompanies(){
        for(Company c: CompanyDAO.findAll()){
            System.out.println(c);
        }
    }

    public static void findAllCustomer(){
        for(Customer cu: CustomerDAO.findAll()){
            System.out.println(cu);
        }
    }
}

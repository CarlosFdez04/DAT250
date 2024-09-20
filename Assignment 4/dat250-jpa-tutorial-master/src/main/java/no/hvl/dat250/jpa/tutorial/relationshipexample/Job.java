package no.hvl.dat250.jpa.tutorial.relationshipexample;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Job {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDescr() {
        return jobDescr;
    }

    public void setJobDescr(String jobDescr) {
        this.jobDescr = jobDescr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salary;
    private String jobDescr;

    // getters and setters


}
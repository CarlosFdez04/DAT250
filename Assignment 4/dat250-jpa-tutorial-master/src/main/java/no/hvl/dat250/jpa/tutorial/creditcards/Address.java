package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Set<Customer> getOwners() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToMany(mappedBy = "creditCards", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("id")  // Ordenar por ID para garantizar consistencia
    private List<Customer> customers = new ArrayList<>();  // Volver a List

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    private Pincode pincode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    public void setOwingBank(Bank bank) {
        this.bank = bank;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

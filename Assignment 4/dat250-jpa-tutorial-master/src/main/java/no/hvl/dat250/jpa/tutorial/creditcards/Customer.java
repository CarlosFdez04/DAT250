package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<Address> addresses = new HashSet<>();  // Cambiado a Set

    @ManyToMany
    @JoinTable(
            name = "customer_creditcard",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "creditcard_id")
    )
    private List<CreditCard> creditCards = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
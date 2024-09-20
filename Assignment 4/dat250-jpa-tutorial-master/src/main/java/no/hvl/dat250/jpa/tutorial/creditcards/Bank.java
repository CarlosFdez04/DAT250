package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditCard> creditCards = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CreditCard> getCreditCards() {
        return new HashSet<>(creditCards);
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards.clear();
        if (creditCards != null) {
            this.creditCards.addAll(creditCards);
        }
    }
}

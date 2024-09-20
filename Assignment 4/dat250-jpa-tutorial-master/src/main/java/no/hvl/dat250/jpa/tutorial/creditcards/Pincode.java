package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pincode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer count;

    @OneToMany(mappedBy = "pincode")
    private List<CreditCard> creditCards = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
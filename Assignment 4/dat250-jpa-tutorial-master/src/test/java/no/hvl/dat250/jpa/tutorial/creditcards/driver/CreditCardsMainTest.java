package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import no.hvl.dat250.jpa.tutorial.creditcards.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCardsMainTest {

    private EntityManagerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(CreditCardsMain.PERSISTENCE_UNIT_NAME);
    }

    @Test
    public void testDomainModelPersistence() {
        // Run the main class to persist the objects.
        CreditCardsMain.main(new String[]{});

        EntityManager em = factory.createEntityManager();

        // Load customer
        Customer customer = em.find(Customer.class, 1L);

        // Test person data
        assertEquals(customer.getName(), "Max Mustermann");

        // Test address
        assertEquals(customer.getAddresses().size(), 1);
        Address address = customer.getAddresses().iterator().next();

        assertEquals(address.getStreet(), "Inndalsveien");
        assertEquals(address.getNumber(), 28);
        assertEquals(address.getOwners(), Set.of(customer));

        // Test credit cards
        assertEquals(customer.getCreditCards().size(), 2);
        CreditCard firstCard = getCardWithNumber(customer, 12345);
        CreditCard secondCard = getCardWithNumber(customer, 123);

        assertEquals(firstCard.getNumber(), 12345);
        assertEquals(firstCard.getBalance(), -5000);
        assertEquals(firstCard.getCreditLimit(), -10000);

        assertEquals(secondCard.getNumber(), 123);
        assertEquals(secondCard.getBalance(), 1);
        assertEquals(secondCard.getCreditLimit(), 2000);

        // Test pincode
        Pincode firstCardPincode = firstCard.getPincode();

        assertEquals(firstCardPincode.getId(), secondCard.getPincode().getId()); // Pincode objects of the two cards are identical!
        assertEquals(firstCardPincode.getCode(), "123");
        assertEquals(firstCardPincode.getCount(), 1);

        // Test bank
        Bank bank = firstCard.getOwningBank();
        assertEquals(bank.getId(),secondCard.getOwningBank().getId()); // Bank objects of the two cards are identical!
        assertEquals(bank.getName(), "Pengebank");
        assertEquals(bank.getCreditCards(), Set.of(firstCard, secondCard));
    }

    private CreditCard getCardWithNumber(Customer customer, int cardNumber) {
        Optional<CreditCard> optionalCard = customer.getCreditCards().stream()
                .filter(creditCard -> creditCard.getNumber() == cardNumber)
                .findFirst();
        if (optionalCard.isEmpty()) {
            throw new RuntimeException(
                    String.format("Card with number %s was not found for the person %s!",
                            cardNumber,
                            customer.getName()));
        }
        return optionalCard.get();
    }
}
package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.List;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // Crear un nuevo cliente
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Crear una dirección
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    customer.setAddresses(Set.of(address));  // Cambiado a Set

    // Crear las tarjetas de crédito
    CreditCard firstCard = new CreditCard();
    firstCard.setNumber(12345);
    firstCard.setBalance(-5000);
    firstCard.setCreditLimit(-10000);

    CreditCard secondCard = new CreditCard();
    secondCard.setNumber(123);
    secondCard.setBalance(1);
    secondCard.setCreditLimit(2000);

    customer.setCreditCards(List.of(firstCard, secondCard));  // Cambiado a Set

    // Crear el código PIN
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);
    firstCard.setPincode(pincode);
    secondCard.setPincode(pincode);

    // Crear el banco
    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.setCreditCards(Set.of(firstCard, secondCard));  // Cambiado a Set
    firstCard.setOwingBank(bank);
    secondCard.setOwingBank(bank);

    // Persistir los objetos en el orden correcto
    em.persist(bank);
    em.persist(pincode);
    em.persist(address);
    em.persist(customer);
    em.persist(firstCard);
    em.persist(secondCard);
  }
}

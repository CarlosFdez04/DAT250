package no.hvl.dat250.jpa.tutorial.basicexample;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {


  public static void main(String[] args) {

    try (
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-tutorial");
            EntityManager em = factory.createEntityManager()) {

      readAndPrintTodos(em);

      // Insert new object
      em.getTransaction().begin();
      Todo todo = new Todo();
      todo.setSummary("test summary");
      todo.setDescription("test description");
      em.persist(todo);
      em.getTransaction().commit();

      readAndPrintTodos(em);
    }
  }

  @SuppressWarnings("unchecked")
  private static void readAndPrintTodos(EntityManager em) {
    Query q = em.createQuery("select t from Todo t");
    List<Todo> todoList = q.getResultList();
    for (Todo todo : todoList) {
      System.out.println(todo);
    }
    System.out.println("Size: " + todoList.size());
  }
}

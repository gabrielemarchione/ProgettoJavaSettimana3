package gabrielemarchione.dao;


import gabrielemarchione.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class LoanDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoJavaSettimana3");

    public void save(Loan loan) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(loan);
        em.getTransaction().commit();
        em.close();
    }

    public Loan findById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Loan loan = em.find(Loan.class, id);
        em.close();
        return loan;
    }

    public List<Loan> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Loan> loans = em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
        em.close();
        return loans;
    }

    public void update(Loan loan) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(loan);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Loan loan) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(loan) ? loan : em.merge(loan));
        em.getTransaction().commit();
        em.close();
    }
}


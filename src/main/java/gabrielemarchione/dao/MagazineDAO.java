package gabrielemarchione.dao;

import gabrielemarchione.entities.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MagazineDAO {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoJavaSettimana3");

    public void save(Magazine magazine) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(magazine);
        em.getTransaction().commit();
        em.close();
    }

    public Magazine findById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Magazine magazine = em.find(Magazine.class, id);
        em.close();
        return magazine;
    }

    public List<Magazine> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Magazine> magazines = em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
        em.close();
        return magazines;
    }

    public void update(Magazine magazine) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(magazine);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Magazine magazine) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(magazine) ? magazine : em.merge(magazine));
        em.getTransaction().commit();
        em.close();
    }
}


package gabrielemarchione.dao;

import gabrielemarchione.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


public class BookDao {



    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoJavaSettimana3");

    public void save(Book book) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public Book findById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }

    public List<Book> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        em.close();
        return books;
    }

    public void update(Book book) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Book book) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(book) ? book : em.merge(book));
        em.getTransaction().commit();
        em.close();
    }
}


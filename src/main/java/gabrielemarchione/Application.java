package gabrielemarchione;

import gabrielemarchione.dao.BookDao;
import gabrielemarchione.dao.LoanDAO;
import gabrielemarchione.dao.MagazineDAO;
import gabrielemarchione.dao.UserDAO;
import gabrielemarchione.entities.Book;
import gabrielemarchione.entities.Loan;
import gabrielemarchione.entities.Magazine;
import gabrielemarchione.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoJavaSettimana3");

        EntityManager em = emf.createEntityManager();
        BookDao bookDAO = new BookDao();
        MagazineDAO magazineDAO = new MagazineDAO();
        UserDAO userDAO = new UserDAO();
        LoanDAO loanDAO = new LoanDAO();
        em.getTransaction().begin();
        Book book1 = new Book();
        book1.setTitle("Il Signore degli Anelli");
        book1.setIsbn("111-111-111");
        book1.setYearOfPublication(1954);
        book1.setNumberOfPages(1178);
        book1.setAuthor("J.R.R. Tolkien");
        book1.setGenre("Fantasy");
        bookDAO.save(book1);

        Book book2 = new Book();
        book2.setTitle("1984");
        book2.setIsbn("222-222-222");
        book2.setYearOfPublication(1949);
        book2.setNumberOfPages(328);
        book2.setAuthor("George Orwell");
        book2.setGenre("Dystopian");
        bookDAO.save(book2);

        Magazine magazine1 = new Magazine();
        magazine1.setTitle("National Geographic");
        magazine1.setIsbn("333-333-333");
        magazine1.setYearOfPublication(2021);
        magazine1.setNumberOfPages(120);
        magazine1.setPeriodicity("Mensile");
        magazineDAO.save(magazine1);

        Magazine magazine2 = new Magazine();
        magazine2.setTitle("Time");
        magazine2.setIsbn("444-444-444");
        magazine2.setYearOfPublication(2022);
        magazine2.setNumberOfPages(80);
        magazine2.setPeriodicity("Settimanale");
        magazineDAO.save(magazine2);

        User user1 = new User();
        user1.setName("Aldo");
        user1.setSurname("Baglio");
        user1.setDateOfBirth(LocalDate.of(1980, 5, 15));
        user1.setMembershipNumber("MR123");
        userDAO.save(user1);

        User user2 = new User();
        user2.setName("Giacomo");
        user2.setSurname("Poretti");
        user2.setDateOfBirth(LocalDate.of(1990, 7, 22));
        user2.setMembershipNumber("AB456");
        userDAO.save(user2);

        em.close();
        emf.close();


        /*Loan loan1 = new Loan();
        loan1.setUser(user1);
        loan1.setLoanedItem(book1);
        loanDAO.save(loan1);

        Loan loan2 = new Loan();
        loan2.setUser(user2);
        loan2.setLoanedItem(magazine1);
        loanDAO.save(loan2);
*/
        System.out.println("Libri nel catalogo:");
        List<Book> books = bookDAO.findAll();
        for (Book book : books) {
            System.out.println("Titolo: " + book.getTitle() + ", ISBN: " + book.getIsbn() +
                    ", Autore: " + book.getAuthor() + ", Genere: " + book.getGenre());
        }


        System.out.println("Riviste nel catalogo:");
        List<Magazine> magazines = magazineDAO.findAll();
        for (Magazine magazine : magazines) {
            System.out.println("Titolo: " + magazine.getTitle() + ", ISBN: " + magazine.getIsbn() +
                    ", Periodicità: " + magazine.getPeriodicity());
        }


        System.out.println("Prestiti");
        List<Loan> loans = loanDAO.findAll();
        for (Loan loan : loans) {
            System.out.println("Utente: " + loan.getUser().getName() + " " + loan.getUser().getSurname() +
                    ", Elemento preso in prestito: " + loan.getLoanedItem().getTitle() +
                    ", Data inizio: " + loan.getLoanStartDate() +
                    ", Data prevista di restituzione: " + loan.getExpectedReturnDate());
        }
        em.close();
        emf.close();
    }
}

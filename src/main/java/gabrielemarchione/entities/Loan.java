package gabrielemarchione.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item loanedItem;

    private LocalDate loanStartDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;

    public Loan() {
        this.loanStartDate = LocalDate.now();
        this.expectedReturnDate = this.loanStartDate.plusDays(30);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getLoanedItem() {
        return loanedItem;
    }

    public void setLoanedItem(Item loanedItem) {
        this.loanedItem = loanedItem;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = loanStartDate.plusDays(30);
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}


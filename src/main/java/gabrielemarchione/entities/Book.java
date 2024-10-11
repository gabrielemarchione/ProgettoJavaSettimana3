package gabrielemarchione.entities;

import jakarta.persistence.Entity;

@Entity

public class Book extends Item {

    private String author;
    private String genre;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}


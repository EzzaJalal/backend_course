package fi.haagahelia.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @Column(name = "publication_year") // Avoid reserved keyword "year"
    private int publicationYear;

    private String isbn;
    private double price;

    public Book() {
    } // No-args constructor required for JPA

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

/*
 * import jakarta.persistence.*;
 * 
 * @Entity
 * public class Book {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO)
 * private Long id;
 * private String title;
 * private String author;
 * private String isbn;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "category_id")
 * private Category category;
 * 
 * 
 * // Getters and Setters
 * public Long getId() {
 * return id;
 * }
 * 
 * public void setId(Long id) {
 * this.id = id;
 * }
 * 
 * public String getTitle() {
 * return title;
 * }
 * 
 * public void setTitle(String title) {
 * this.title = title;
 * }
 * 
 * public String getAuthor() {
 * return author;
 * }
 * 
 * public void setAuthor(String author) {
 * this.author = author;
 * }
 * 
 * public String getIsbn() {
 * return isbn;
 * }
 * 
 * public void setIsbn(String isbn) {
 * this.isbn = isbn;
 * }
 * 
 * public Category getCategory() {
 * return category;
 * }
 * 
 * public void setCategory(Category category) {
 * this.category = category;
 * }
 * 
 * @Override
 * public String toString() {
 * return "Book [id=" + id + ", title=" + title + ", author=" + author +
 * ", isbn=" + isbn + "]";
 * }
 * }
 */
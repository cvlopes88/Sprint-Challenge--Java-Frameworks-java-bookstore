package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    @Column(nullable = false)
    private String bookTitle;
    @Column(nullable = false, unique = true)
    private String isbn;
    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionId", nullable = false)
    @JsonIgnoreProperties("book")
    private Section section;


//
//    @ManyToMany
//    @JoinColumn(name = "books")
//    private List<Author> authors = new ArrayList<>();

    public Book(String bookTitle, String isbn, int copy) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copy=" + copy +
                '}';
    }
}

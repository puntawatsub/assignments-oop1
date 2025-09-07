package assignment3_3.two_and_three.library.model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean reserved;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return (Objects.equals(book.getAuthor(), this.getAuthor()) && Objects.equals(book.getISBN(), this.getISBN()) && Objects.equals(book.getTitle(), this.getTitle()) && book.isReserved() == this.isReserved());
    }
}

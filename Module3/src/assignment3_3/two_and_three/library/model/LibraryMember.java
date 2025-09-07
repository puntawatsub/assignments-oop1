package assignment3_3.two_and_three.library.model;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private int memberId;
    private ArrayList<Book> borrowedBook;
    private ArrayList<Book> reservedBook;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBook = new ArrayList<>();
        this.reservedBook = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        this.borrowedBook.add(book);
    }

    public void returnBook(Book book) {
        if (!borrowedBook.contains(book)) {
            return;
        }
        borrowedBook.remove(book);
    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void addReservedBook(Book book) {
        reservedBook.add(book);
    }

    public void removeReservedBook(Book book) {
        reservedBook.remove(book);
    }

    public ArrayList<Book> getReservedBooks() {
        return reservedBook;
    }

    public boolean hasReservedBook(Book book) {
        return reservedBook.contains(book);
    }
}

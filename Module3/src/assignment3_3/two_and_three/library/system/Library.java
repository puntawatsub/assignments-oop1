package assignment3_3.two_and_three.library.system;

import assignment3_3.two_and_three.library.model.Book;
import assignment3_3.two_and_three.library.model.LibraryMember;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<LibraryMember> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<LibraryMember> getMembers() {
        return members;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addMembers(LibraryMember member) {
        members.add(member);
    }

    public void returnBook(Book book, LibraryMember member) {
        member.returnBook(book);
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void borrowBook(Book book, LibraryMember member) {
        member.borrowBook(book);
        books.remove(book);
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }
}

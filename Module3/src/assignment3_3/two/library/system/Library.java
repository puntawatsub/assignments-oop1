package assignment3_3.two.library.system;

import assignment3_3.two.library.model.Book;
import assignment3_3.two.library.model.LibraryMember;

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
}

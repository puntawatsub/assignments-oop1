package assignment3_3.two.library;

import assignment3_3.two.library.model.Book;
import assignment3_3.two.library.model.LibraryMember;
import assignment3_3.two.library.system.Library;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        for (int i = 1; i <= 5; i++) {
            library.addMembers(new LibraryMember("Member" + i, i));
        }
        library.addBook(new Book("Book1", "Author1", "ISBN1"));
        library.addBook(new Book("Book2", "Author2", "ISBN2"));
        library.addBook(new Book("Book3", "Author3", "ISBN3"));
        LibraryMember member1 = library.getMembers().get(0);
        LibraryMember member2 = library.getMembers().get(1);

        Book book1 = library.getBooks().get(0);
        Book book2 = library.getBooks().get(1);
        library.borrowBook(book1, member1);
        library.borrowBook(book2, member2);
        System.out.println(member1.getName() + " borrowed: " + member1.getBorrowedBook().get(0).getTitle());
        System.out.println(member2.getName() + " borrowed: " + member2.getBorrowedBook().get(0).getTitle());
        library.returnBook(book1, member1);
        System.out.println(member1.getName() + " returned: " + book1.getTitle());
        System.out.println("Books available in library:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle());
        }

        library.reserveBook(member1, book1);
        library.displayReservedBooks(member1);

        library.cancelReservation(member1, book1);
        library.displayReservedBooks(member1);
    }
}

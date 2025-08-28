package assignment2_3.one;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // getters
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public int getPublicationYear() {
        return this.publicationYear;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public Library() {
        this.books = new ArrayList<>();
    }

    // methods
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        int count = 0;
        for (Book book: this.books) {
            count++;
            System.out.printf("%d. Title: \"%s\", Author: \"%s\", Year: %d\n", count, book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book> authorBooks = new ArrayList<Book>(this.books.stream().filter(book -> {
            return book.getAuthor().equals(author);
        }).toList());

        if (authorBooks.isEmpty()) {
            System.out.printf("No book from \"%s\".\n", author);
            return;
        }

        System.out.printf("Books by Author \"%s\":\n", author);
        for (Book book: authorBooks) {
            System.out.printf("Title: %s, Year: %d\n", book.getTitle(), book.getPublicationYear());
        }
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        // create books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Introduction to Java Programming", "John Smith", 2020));
        books.add(new Book("Data Structures and Algorithms", "Jane Doe", 2018));
        books.add(new Book("The Art of Fiction", "Alice Johnson", 2019));
        books.add(new Book("How to DOE it", "Jane Doe", 2018));

        // create library and add books to library
        Library library = new Library();
        for (Book book: books) {
            library.addBook(book);
        }

        // display books
        library.displayBooks();

        System.out.println();

        // find books by author
        library.findBooksByAuthor("Jane Doe");
    }
}
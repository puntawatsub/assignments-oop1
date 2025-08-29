package assignment2_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.reviews = new ArrayList<>();
    }

    // setters
    public void setRating(double rating) {
        this.rating = rating;
    }

    // methods
    public void addReview(String review) {
        this.reviews.add(review);
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
    public ArrayList<String> getReviews() {
        return this.reviews;
    }
    public double getRating() {
        return this.rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Book checkBook = (Book) obj;
        return this.getTitle().equals(checkBook.getTitle()) && this.getAuthor().equals(checkBook.getAuthor()) && this.getPublicationYear() == checkBook.getPublicationYear();
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> borrowedBook;
    private ArrayList<User> users;


    public Library() {
        this.books = new ArrayList<>();
        this.borrowedBook = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // methods

    public double getAverageBookRating() {
        double cumulativeRating = 0;
        double average;
        for (Book book: books) {
            cumulativeRating += book.getRating();
        }
        if (books.isEmpty()) {
            return 0.0;
        }
        average = cumulativeRating / books.size();

        return average;
    }

    private Comparator<Book> reviewComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o1.getReviews().size(), o2.getReviews().size());
        }
    };

    public Book getMostReviewedBook() {
        ArrayList<Book> bookForComparison = new ArrayList<>(books);
        Collections.sort(bookForComparison, reviewComparator);
        return bookForComparison.get(bookForComparison.size() - 1);
    }

    public void addBook(Book book) {
        ArrayList<Book> bookWithTitle = new ArrayList<Book>(
                this.books.stream().filter(b -> {
                    return b.getTitle().equals(book.getTitle());
                }).toList()
        );

        if (!bookWithTitle.isEmpty()) {
            System.out.println("More than one book of same name. Book not added.");
            return;
        }
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

    public boolean isBookAvailable(String title) {
        ArrayList<Book> bookWithTitle = new ArrayList<Book>(
                this.books.stream().filter(book -> book.getTitle().equals(title)).toList()
        );
        return !bookWithTitle.isEmpty();
    }

    public void borrowBook(String title, User user) {
        ArrayList<Book> bookWithTitle = new ArrayList<Book>(
                this.books.stream().filter(book -> book.getTitle().equals(title)).toList()
        );

        if (bookWithTitle.isEmpty()) {
            System.out.printf("Book with title \"%s\" not found\n", title);
            return;
        } else if (bookWithTitle.size() > 1) {
            System.out.printf("More than 1 books with title \"%s\"\n", title);
            return;
        }

        this.borrowedBook.add(bookWithTitle.get(0));
        this.books.remove(bookWithTitle.get(0));

        // add user if not registered
        if (!this.users.contains(user)) {
            this.users.add(user);
        }

        // add borrowed book to user
        user.addBorrowedBook(bookWithTitle.get(0));
    }

    public void returnBook(Book book, User user) {

        ArrayList<Book> searchBorrowedBook = new ArrayList<>(this.borrowedBook.stream().filter(b -> b.equals(book)).toList());

        if (searchBorrowedBook.size() != 1) {
            System.out.printf("Book with name \"%s\" had not been borrowed from this library.\n", book.getTitle());
            return;
        }
        if (!user.getBorrowedBook().contains(book)) {
            System.out.printf("User \"%s\" haven't borrowed book \"%s\".\n", user.getName(), book.getTitle());
            return;
        }

        this.addBook(book);
        this.borrowedBook.remove(book);

        // remove borrowed book from user
        user.removeBorrowedBook(book);
    }
}

public class LibraryMain {
    public static void main(String[] args) {

        // create user
        User user1 = new User("User1", 20);
        User user2 = new User("User2", 19);

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
        System.out.println();

        // borrow
        library.borrowBook("How to DOE it", user1);
        library.borrowBook("How to DOE it", user1);

        // is book available
        System.out.println(library.isBookAvailable("How to DOE it"));

        // display book
        library.displayBooks();
        System.out.println();

        // return book
        library.returnBook(new Book("How to DOE it", "Jane Doe", 2018), user2);
        library.returnBook(new Book("How to DOE it", "Jane Doe", 2018), user1);

        // is book available
        System.out.println(library.isBookAvailable("How to DOE it"));
    }
}

class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBook;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBook = new ArrayList<>();
    }

    public void addBorrowedBook(Book book) {
        this.borrowedBook.add(book);
    }

    public void removeBorrowedBook(Book book) {
        this.borrowedBook.remove(book);
    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
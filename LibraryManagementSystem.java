import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String publicationDate;
    private boolean isAvailable;

    public Book(String title, String author, String publicationDate, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Collection:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publication Date: " + book.getPublicationDate());
            System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
            System.out.println();
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailability(false);
                    System.out.println("Book '" + title + "' checked out successfully.");
                    return;
                } else {
                    System.out.println("Book '" + title + "' is not available for checkout.");
                    return;
                }
            }
        }
        System.out.println("Book '" + title + "' not found in the library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailability(true);
                System.out.println("Book '" + title + "' returned successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the library.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925", true));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "1960", true));
        library.addBook(new Book("1984", "George Orwell", "1949", true));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "1813", true));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "1951", true));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("-------------------------");
            System.out.println("1. Display Books");
            System.out.println("2. Check Out Book");
            System.out.println("3. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to check out: ");
                    scanner.nextLine(); // Consume the newline character
                    String checkoutTitle = scanner.nextLine();
                    library.checkOutBook(checkoutTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine(); // Consume the newline character
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}

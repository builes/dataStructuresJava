import java.util.*;

// Book class implements Comparable to provide natural ordering by title
class Book1 implements Comparable<Book1> {
    String title;
    String author;
    double price;

    // Constructor for Book
    Book1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Implementing compareTo to sort by title by default
    @Override
    public int compareTo(Book1 other) {
        return this.title.compareTo(other.title);  // Natural ordering by title
    }

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Price: $" + price;
    }

    // Getters for fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

// Comparator for sorting books by author's name
class BookAuthorComparator implements Comparator<Book1> {
    @Override
    public int compare(Book1 b1, Book1 b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());  // Sort by author's name
    }
}

// Comparator for sorting books by price
class BookPriceComparator implements Comparator<Book1> {
    @Override
    public int compare(Book1 b1, Book1 b2) {
        return Double.compare(b1.getPrice(), b2.getPrice());  // Sort by price
    }
}

public class C12_ComparableAndComparator {
    public static void main(String[] args) {
        List<Book1> books = Arrays.asList(
                new Book1("The Great Gatsby", "F. Scott Fitzgerald", 10.99),
                new Book1("1984", "George Orwell", 8.99),
                new Book1("To Kill a Mockingbird", "Harper Lee", 7.99),
                new Book1("The Catcher in the Rye", "J.D. Salinger", 6.99),
                new Book1("Moby Dick", "Herman Melville", 12.99)
        );

        // Display the books before sorting
        System.out.println("Books before sorting by title:");
        books.forEach(System.out::println);

        // Sort by the natural order using Comparable (sorting by title)
        Collections.sort(books);
        System.out.println("\nBooks after sorting by title:");
        books.forEach(System.out::println);

        // Sort by author using a custom comparator
        Collections.sort(books, new BookAuthorComparator());
        System.out.println("\nBooks after sorting by author:");
        books.forEach(System.out::println);

        // Sort by price using a different custom comparator
        Collections.sort(books, new BookPriceComparator());
        System.out.println("\nBooks after sorting by price:");
        books.forEach(System.out::println);

        // Example using Lambda Expression with Comparator for sorting by author
        System.out.println("\nBooks after sorting by author (Lambda):");
        books.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
        books.forEach(System.out::println);

        // Example using Lambda Expression with Comparator for sorting by price
        System.out.println("\nBooks after sorting by price (Lambda):");
        books.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
        books.forEach(System.out::println);
    }
}

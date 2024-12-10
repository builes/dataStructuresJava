import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private Genre genre;
    private double rating;
    private int pages;

    public Book(String title, String author, Genre genre, double rating, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Genre getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + genre + ", " + rating + "/5 stars, " + pages + " pages)";
    }
}

enum Genre {
    FICTION, NON_FICTION, SCIENCE_FICTION, FANTASY, MYSTERY, BIOGRAPHY, HISTORY
}

public class C7_LambdasAndStreams {
    public static void main(String[] args) {
        List<Book1> books = Arrays.asList(
                new Book1("The Hobbit", "J.R.R. Tolkien", Genre.FANTASY, 4.7, 310),
                new Book1("1984", "George Orwell", Genre.SCIENCE_FICTION, 4.6, 328),
                new Book1("To Kill a Mockingbird", "Harper Lee", Genre.FICTION, 4.8, 281),
                new Book1("A Brief History of Time", "Stephen Hawking", Genre.NON_FICTION, 4.5, 212),
                new Book1("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION, 4.4, 180),
                new Book1("The Silent Patient", "Alex Michaelides", Genre.MYSTERY, 4.3, 336),
                new Book1("Steve Jobs", "Walter Isaacson", Genre.BIOGRAPHY, 4.7, 656)
        );

        // 1. Print all books in the library
        System.out.println("All Books:");
        books.forEach(System.out::println);

        System.out.println("\nBooks with rating higher than 4.5:");
        // 2. Filter books with rating higher than 4.5
        books.stream()
                .filter(book -> book.getRating() > 4.5)
                .forEach(System.out::println);

        System.out.println("\nAll Book Titles:");
        // 3. Map books to their titles
        List<String> titles = books.stream()
                .map(Book1::getTitle)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);

        System.out.println("\nBooks Grouped by Genre:");
        // 4. Group books by genre
        Map<Genre, List<Book1>> booksByGenre = books.stream()
                .collect(Collectors.groupingBy(Book1::getGenre));
        booksByGenre.forEach((genre, genreBooks) -> {
            System.out.println("Genre: " + genre);
            genreBooks.forEach(book -> System.out.println("  " + book));
        });

        System.out.println("\nAverage Rating of Books:");
        // 5. Calculate the average rating of all books
        double averageRating = books.stream()
                .mapToDouble(Book1::getRating)
                .average()
                .orElse(0.0);
        System.out.println("Average Rating: " + averageRating);

        System.out.println("\nTop Rated Book:");
        // 6. Find the top-rated book
        books.stream()
                .max(Comparator.comparingDouble(Book1::getRating))
                .ifPresent(System.out::println);

        System.out.println("\nTotal Number of Pages in All Books:");
        // 7. Sum up the total pages of all books
        int totalPages = books.stream()
                .mapToInt(Book1::getPages)
                .sum();
        System.out.println("Total Pages: " + totalPages);

        System.out.println("\nBooks with 'Time' in the Title:");
        // 8. Find books with "Time" in their title
        books.stream()
                .filter(book -> book.getTitle().contains("Time"))
                .forEach(System.out::println);

        System.out.println("\nGenres with Average Rating Greater Than 4.5:");
        // 9. Find genres with an average rating greater than 4.5
        books.stream()
                .collect(Collectors.groupingBy(Book1::getGenre, Collectors.averagingDouble(Book1::getRating)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4.5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("\nTop 3 Longest Books:");
        // 10. Find the top 3 longest books
        books.stream()
                .sorted(Comparator.comparingInt(Book1::getPages).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nDistinct Authors:");
        // 11. Find all distinct authors
        books.stream()
                .map(Book1::getAuthor)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nBooks Sorted by Title:");
        // 12. Sort books by title alphabetically
        books.stream()
                .sorted(Comparator.comparing(Book1::getTitle))
                .forEach(System.out::println);

        System.out.println("\nBook Titles in Uppercase:");
        // 13. Convert all book titles to uppercase
        books.stream()
                .map(book -> book.getTitle().toUpperCase())
                .forEach(System.out::println);

        System.out.println("\nMap of Books by Author:");
        // 14. Create a map of authors to list of their books
        Map<String, List<Book1>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book1::getAuthor));
        booksByAuthor.forEach((author, authorBooks) -> {
            System.out.println("Author: " + author);
            authorBooks.forEach(book -> System.out.println("  " + book));
        });

        System.out.println("\nCheck if all books have more than 100 pages:");
        // 15. Check if all books have more than 100 pages
        boolean allMoreThan100Pages = books.stream()
                .allMatch(book -> book.getPages() > 100);
        System.out.println("All books have more than 100 pages: " + allMoreThan100Pages);

        System.out.println("\nCheck if any book has a rating below 4.0:");
        // 16. Check if any book has a rating below 4.0
        boolean anyBelowFour = books.stream()
                .anyMatch(book -> book.getRating() < 4.0);
        System.out.println("Any book has a rating below 4.0: " + anyBelowFour);

        System.out.println("\nCount of Books per Genre:");
        // 17. Count books per genre
        Map<Genre, Long> countByGenre = books.stream()
                .collect(Collectors.groupingBy(Book1::getGenre, Collectors.counting()));
        countByGenre.forEach((genre, count) -> System.out.println(genre + ": " + count + " books"));

        System.out.println("\nList of Genres in the Library:");
        // 18. List all genres present in the library
        books.stream()
                .map(Book1::getGenre)
                .distinct()
                .forEach(System.out::println);
    }
}

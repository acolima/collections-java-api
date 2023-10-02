package main.list.Search.BooksCatalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> catalog;

    public Catalog() {
        this.catalog = new ArrayList<>();
    }

    public void addBook(String title, String author, int publishingYear) {
        Book newBook = new Book(title, author, publishingYear);

        catalog.add(newBook);
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> booksFromAuthor = new ArrayList<>();

        for(Book book : catalog) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                booksFromAuthor.add(book);
            }
        }

        return booksFromAuthor;
    }

    public List<Book> searchByYearRange(int initialYear, int finalYear) {
        List<Book> booksInYearRange = new ArrayList<>();

        for(Book book : catalog) {
            int publishingYear = book.getPublishingYear();
            if(publishingYear >= initialYear && publishingYear <= finalYear) {
                booksInYearRange.add(book);
            }
        }

        return booksInYearRange;
    }

    public Book searchByTitle(String title) {
        Book bookByTitle = null;

        for(Book book: catalog) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                bookByTitle = book;
                break;
            }
        }

        return bookByTitle;
    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.addBook("Book 1", "Author 1", 2020);
        catalog.addBook("Book 1", "Author 2", 2021);
        catalog.addBook("Book 2", "Author 2", 2022);
        catalog.addBook("Book 3", "Author 3", 2023);
        catalog.addBook("Book 4", "Author 4", 1994);

        System.out.println(catalog.searchByAuthor("Author 2"));

        System.out.println(catalog.searchByYearRange(2020, 2022));

        System.out.println(catalog.searchByTitle("Book 1"));
    }
}

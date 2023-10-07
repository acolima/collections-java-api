package main.map.Sort.Bookshop;

import java.util.*;

public class Bookshop {
    private Map<String, Book> books;

    public Bookshop() {
        books = new HashMap<>();
    }

    public void addBook(String link, String title, String author, double price) {
        Book newBook = new Book(title, author, price);
        books.put(link, newBook);
    }

    public void removeBook(String title) {
        List<String> bookToRemove = new ArrayList<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                bookToRemove.add(entry.getKey());
            }
        }

        for (String key : bookToRemove) {
            books.remove(key);
        }
    }

    public Map<String, Book> sortByPrice() {
        List<Map.Entry<String, Book>> booksToSort = new ArrayList<>(books.entrySet());

        Collections.sort(booksToSort, new Book.ComparatorByPrice());

        Map<String, Book> booksSorted = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : booksToSort) {
            booksSorted.put(entry.getKey(), entry.getValue());
        }

        return booksSorted;
    }

    public Map<String, Book> searchByAuthor(String author) {
        Map<String, Book> booksByAuthor = new LinkedHashMap<>();

        for(Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if(book.getAuthor().equals(author)) {
                booksByAuthor.put(entry.getKey(), book);
            }
        }

        return booksByAuthor;
    }

    public Book getMostExpensiveBook() {
        Book expensiveBook = null;
        double price = Double.MIN_VALUE;

        if (!books.isEmpty()) {
            for (Book book : books.values()) {
                if (book.getPrice() > price) {
                    price = book.getPrice();
                    expensiveBook = book;
                }
            }
        } else {
            System.out.println("The book list is empty");
        }

        return expensiveBook;
    }

    public Book getCheaperBook() {
        Book cheaperBook = null;
        double price = Double.MAX_VALUE;

        if (!books.isEmpty()) {
            for (Book book : books.values()) {
                if (book.getPrice() < price) {
                    price = book.getPrice();
                    cheaperBook = book;
                }
            }
        } else {
            System.out.println("The book list is empty");
        }

        return cheaperBook;
    }

    public static void main(String[] args) {
        Bookshop bookshop = new Bookshop();

        bookshop.addBook("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50);
        bookshop.addBook("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7);
        bookshop.addBook("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99);
        bookshop.addBook("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5);
        bookshop.addBook("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 100);
        bookshop.addBook("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5);

        System.out.println("Books sorted by price: \n" + bookshop.sortByPrice());


        bookshop.searchByAuthor("Josh Malerman");

        System.out.println("Livro mais caro: " + bookshop.getMostExpensiveBook());

        System.out.println("Livro mais barato: " + bookshop.getCheaperBook());

        System.out.println("Removing book");
        bookshop.removeBook("1984");
        System.out.println(bookshop.books);

    }

}

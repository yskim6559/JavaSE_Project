package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private String name;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (title.equals(book.getTitle())) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (isbn.equals(book.getIsbn())){
                return book;
            }
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            return false;
        }
        return book.checkOut();
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            return false;
        }
        if (book.isAvailable()) {
            return false;
        }
        book.returnBook();
        return true;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
             result.add(book);
        }
        return result;
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}

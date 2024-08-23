package com.arife.library;

import com.arife.library.bookTypes.BookType;
import com.arife.people.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookservice implements LibraryInterface{
    private Map<Integer, Book> books;
    private Map<String, Reader> borrowedBooks;

    public Bookservice() {
        this.borrowedBooks = new HashMap<>();
        this.books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    @Override
    public Book findBookById(Long id) {

        return books.get(id.intValue());
    }

    @Override
    public List<Book> findBooksByName(String name) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void updateBook(Book book) {
        books.put(book.getBookId(), book);
    }

    @Override
    public void deleteBook(Long id) {
        books.remove(id.intValue());
    }

    @Override
    public Map<String, Reader> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> findBooksByCategory(String categoryName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getBookType() == BookType.valueOf(categoryName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByOwner(Reader reader) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getOwner() != null && book.getOwner().equals(reader)) {
                result.add(book);
            }
        }
        return result;
    }
}

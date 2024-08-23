package com.arife.library;

import com.arife.people.Reader;

import java.util.List;
import java.util.Map;

public interface LibraryInterface {
    void addBook(Book book);
    Book findBookById(Long id);
    List<Book> findBooksByName(String name);
    List<Book> findBooksByAuthor(String authorname);
    void updateBook(Book book);
    void deleteBook(Long id);
    Map<String, Reader> getBorrowedBooks();
}

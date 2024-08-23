package com.arife.people;

import com.arife.library.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Author extends Person {
    private int id;
    private Set<Book> books;

    public Author(String name, int id) {
        super(name);
        this.id = id;
        books = new HashSet<>();
    }

    public Author(String name, int id, Set<Book> books) {
        super(name);
        this.id = id;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println("This book added to the book list :"+book.getBookId()+" "+book.getBookName());
    }
    public void showBook(){
        for(Book book:books){
            System.out.println(book);
        }

    }
    public void removeBook(String book){
        books.remove(book);
        System.out.println("This book removed from the book list :"+book.toString());
    }

    @Override
    public void whoAreYou() {
        System.out.println("Author name is "+this.getName() );
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                "name=" + this.getName() +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

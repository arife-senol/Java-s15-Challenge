package com.arife.people;

import java.util.Objects;
import java.util.Set;

public class Author extends Person {
    private int id;
    private Set<String> books;

    public Author(String name, int id, Set<String> books) {
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

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }
    public void newBook(String book){
        books.add(book);
        System.out.println("This book added to the book list :"+book);
    }
    public void showBook(){
        for(String book:books){
            System.out.println(book);
        }

    }
    public void removeBook(String book){
        books.remove(book);
        System.out.println("This book removed from the book list :"+book);
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

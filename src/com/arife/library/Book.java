package com.arife.library;

import com.arife.library.bookTypes.BookType;
import com.arife.people.Author;
import com.arife.people.Reader;

import java.util.Date;
import java.util.Objects;

public class Book {
    private int bookId;
    private String bookName;
    private Author author;
    private double price;
    private boolean status;
    private int edition;
    private Date dateOfPurchase;
    private BookType bookType;
    private Reader owner;
    private boolean isAvailable;


    public Book(int bookId, String bookName, Author author, double price, boolean status, int edition, Date dateOfPurchase, BookType bookType) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.bookType=bookType;
        this.owner=null;
        this.isAvailable=true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {

        this.bookType = bookType;
    }

    public boolean isStatus() {
        return status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void getTitle(){
        System.out.println(this.bookName+" "+this.author.getName()+" "+this.edition);
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public void changeOwner(String authorName){
        author.setName(authorName);
        System.out.println("Author name changed to "+authorName);
    }
    public Reader getOwner(){
        return owner;
    }
    public void display(){
        System.out.println(this.toString());
    }
    public void updateStatus(boolean status){
        setStatus(status);
        System.out.println("Status updated to " + status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(bookName, book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + author.getName() +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition=" + edition +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}

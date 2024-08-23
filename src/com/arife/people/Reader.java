package com.arife.people;

import com.arife.library.Book;
import com.arife.people.enums.ReaderType;
import com.arife.people.info.Address;
import com.arife.utils.IdGenerate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reader extends Person {
private int id;
private List<Book> books;
private List<Invoice> invoices;
private String phoneNo;
private Date dateOfMemberShip;
private int maxBookLimit;
private int noBookIssued;
private ReaderType readerType;
private Address address;

    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public Reader(String name, int id, String phoneNo, Date dateOfMemberShip, int maxBookLimit, int noBookIssued, ReaderType readerType, Address address) {
        super(name);
        this.id = id;
        this.books = new ArrayList<>();
        this.phoneNo = phoneNo;
        this.dateOfMemberShip = dateOfMemberShip;
        this.maxBookLimit = maxBookLimit;
        this.noBookIssued = noBookIssued;
        this.readerType = readerType;
        this.address = address;
        this.invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDateOfMemberShip() {
        return dateOfMemberShip;
    }

    public void setDateOfMemberShip(Date dateOfMemberShip) {
        this.dateOfMemberShip = dateOfMemberShip;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public int getNoBookIssued() {
        return noBookIssued;
    }

    public void setNoBookIssued(int noBookIssued) {
        this.noBookIssued = noBookIssued;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void purchaseBook(Book book, double price) {
        if (book.isAvailable()) {
            books.add(book);
            book.setAvailable(false);
            book.setOwner(this);
            Invoice invoice = new Invoice(IdGenerate.generateId(), this, book, price);
            invoices.add(invoice);
            System.out.println("Kitap satın alındı: " + book.getBookName());
        } else {
            System.out.println("Kitap mevcut değil.");
        }
    }

    public void borrowBook(Book book) {
        if (books.size() < 5 && book.isAvailable()) {
            books.add(book);
            book.setAvailable(false);
            book.setOwner(this);
        } else {
            System.out.println("Kitap limiti doldu veya kitap mevcut değil.");
        }
    }

    public void returnBook(Book book) {
        books.remove(book);
        book.setAvailable(true);
        book.setOwner(null);
        System.out.println("Kitap iade edildi: " + book.getBookName());
    }





    @Override
    public void whoAreYou() {
        System.out.println("Reader name is " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return id == reader.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

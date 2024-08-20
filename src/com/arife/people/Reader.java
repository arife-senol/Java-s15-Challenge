package com.arife.people;

import com.arife.library.Book;
import com.arife.people.enums.ReaderType;
import com.arife.people.info.Address;


import java.util.Date;
import java.util.List;

public class Reader extends Person {
private int id;
private List<Book> books;
private String phoneNo;
private Date dateOfMemberShip;
private int maxBookLimit;
private int noBookIssued;
private ReaderType readerType;
private Address address;

    public Reader(String name, int id, List<Book> books, String phoneNo, Date dateOfMemberShip, int maxBookLimit, int noBookIssued, ReaderType readerType, Address address) {
        super(name);
        this.id = id;
        this.books = books;
        this.phoneNo = phoneNo;
        this.dateOfMemberShip = dateOfMemberShip;
        this.maxBookLimit = maxBookLimit;
        this.noBookIssued = noBookIssued;
        this.readerType = readerType;
        this.address = address;
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

    @Override
    public void whoAreYou() {
        System.out.println("Reader name is " + this.getName());
    }


}

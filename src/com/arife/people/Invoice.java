package com.arife.people;

import com.arife.library.Book;

import java.util.Date;

public class Invoice {
    private int id;
    private Reader reader;
    private Book book;
    private Date issueDate;
    private double amount;

    public Invoice(int id, Reader reader, Book book, double amount) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.issueDate = new Date();
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", reader=" + reader +
                ", book=" + book +
                ", issueDate=" + issueDate +
                ", amount=" + amount +
                '}';
    }
}

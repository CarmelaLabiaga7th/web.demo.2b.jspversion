package com.webshoppe.ecommerce.entity;

import java.math.BigDecimal;

public class Book {
    private String bookId;
    private String bookTitle;
    private String bookDesc;
    private String bookAID;
    private BigDecimal bookPrice;

    public Book() {

    }

    public Book(String bookId, String bookTitle, String bookDesc, String bookAID, BigDecimal bookPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookDesc = bookDesc;
        this.bookAID = bookAID;
        this.bookPrice = bookPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getBookAID() {
        return bookAID;
    }

    public void setBookAID(String bookAID) {
        this.bookAID = bookAID;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

}

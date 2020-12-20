package com.mycompany.library;

import java.util.Arrays;

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0)
            this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if(qty >= 0)
            this.qty = qty;
    }

    @Override
    public String toString() {
        String authorsList = authors[0].toString();
        for(int i = 1; i < authors.length; i++)
            authorsList += ", " + authors[i].toString();
        return "Book{" +
                "name = '" + name + '\'' +
                ", authors = " + "{ " + authorsList + " }" +
                ", price = " + price +
                ", qty = " + qty +
                '}';
    }

    public String getAuthorNames() {
        String authorsNames = authors[0].getName();
        for(int i = 1; i < authors.length; i++)
                authorsNames += ", " + authors[i].getName();
        return authorsNames;
    }
}

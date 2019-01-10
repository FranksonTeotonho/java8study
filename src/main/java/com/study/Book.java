package com.study;

import java.util.Comparator;

public class Book {

    public static Comparator<Book> COMPARE_BY_TITLE_ASC = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareTo(b2.getTitle());
        }

    };
    public static Comparator<Book> COMPARE_BY_PAGE_NUMBER_DESC = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            //return b1.getPageNumbers()>b2.getPageNumbers()?1:b2.getPageNumbers()>b1.getPageNumbers()?-1:0;
            return (int) b2.getPageNumbers() - (int) b1.getPageNumbers();
        }

    };
    public static Comparator<Book> COMPARE_BY_TITLE_DESC = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b2.getTitle().compareTo(b1.getTitle());
        }

    };
    public static Comparator<Book> COMPARE_BY_AUTHOR_AGE = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareTo(b2.getAuthor());
        }
    };
    public static Comparator<Book> COMPARE_BY_AUTHOR_NAME = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareTo(b2.getAuthor());
        }
    };
    private long id;
    private long pageNumbers;
    private double price;
    private String title;
    private Person author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(long pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

}

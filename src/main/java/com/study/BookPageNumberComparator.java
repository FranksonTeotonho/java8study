package com.study;

import java.util.Comparator;

public class BookPageNumberComparator implements Comparator<Book> {

    private final boolean asc;

    public BookPageNumberComparator(boolean asc) {
        this.asc = asc;
    }

    public int compare(Book b1, Book b2) {
        if (asc) {
            return (int) b1.getPageNumbers() - (int) b2.getPageNumbers();
        } else {
            return (int) b2.getPageNumbers() - (int) b1.getPageNumbers();
        }
    }
}

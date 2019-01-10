package com.study;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Book> books;
        List<Person> people;
        List<String> names;
        BookOperations bookOperations;

        //Non-sorted
        bookOperations = new BookOperations();
        books = bookOperations.getBooks();
        bookOperations.printBookList(books);

        //Sorted by pageNumber
        //books = bookOperations.getBooksSortedByPageNumber(false);

        //Sorted by title
        //books = bookOperations.getBooksSortedByTitle(false);

        //Sorted by Author Age
        //books = bookOperations.getBooksSortedByAuthorAge(true);

        //Extract Authors
        people = bookOperations.extractAuthors(books);
        //bookOperations.printPeopleList(people);

        //Extract Author names
        names = bookOperations.extractAuthorNames(people);
        bookOperations.printNamesList(names);




    }
}

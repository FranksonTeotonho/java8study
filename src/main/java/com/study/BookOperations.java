package com.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class BookOperations {

    List<Book> books;

    public BookOperations() {
        books = new ArrayList<Book>(100);
        Book book;
        Person author;
        for (int i = 0; i < 100; i++) {
            //New book and author
            book = new Book();
            author = new Person();

            //Setting author attributes
            author.setName(randomAlphabetic(8));
            author.setCPF(randomNumeric(11));
            author.setAge(randomNumeric(2));

            //Setting book attributes
            book.setId(i);
            book.setTitle(randomAlphabetic(15));
            book.setAuthor(author);
            book.setPageNumbers(Long.parseLong(randomNumeric(3)));
            book.setPrice(Double.parseDouble(randomNumeric(3)));

            books.add(book);

        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void printBookList(List<Book> books) {

        System.out.println("Printing list of books");

        for (int i = 0; i < books.size(); i++) {
            System.out.println("=========================================");

            System.out.println("Id: " + String.valueOf(i));
            System.out.println("Title: " + books.get(i).getTitle());
            System.out.println("Author's name: " + books.get(i).getAuthor().getName());
            System.out.println("Author's age: " + books.get(i).getAuthor().getAge());
            System.out.println("Number of pages: " + String.valueOf(books.get(i).getPageNumbers()));
            System.out.println("Price: " + String.valueOf(books.get(i).getPrice()));

            System.out.println("=========================================");

        }
    }

    public void printPeopleList(List<Person> people) {

        System.out.println("Printing list of people");

        for (int i = 0; i < people.size(); i++) {
            System.out.println("=========================================");

            System.out.println("Author's name: " + people.get(i).getName());
            System.out.println("Author's age: " + people.get(i).getAge());
            System.out.println("Author's CPF: " + people.get(i).getCPF());

            System.out.println("=========================================");

        }
    }

    public void printNamesList(List<String> names){
        System.out.println("Priting list of names");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("=========================================");

            System.out.println("Author's name: " + names.get(i));

            System.out.println("=========================================");
        }
    }

    public List<Book> getBooksSortedByPageNumber(final boolean asc) {

        List<Book> localBooks = getBooks();

        if (asc) {
            Collections.sort(localBooks, new BookPageNumberComparator(asc));
        } else {
            Collections.sort(localBooks, new Comparator<Book>() {
                public int compare(Book a, Book b) {
                    if (asc) {
                        return (int) a.getPageNumbers() - (int) b.getPageNumbers();
                    } else {
                        return (int) a.getPageNumbers() - (int) b.getPageNumbers();
                    }
                }
            });
        }

        return localBooks;
    }

    public List<Book> getBooksSortedByPageNumberAscWithLambda() {

        List<Book> localBooks = getBooks();

        Collections.sort(localBooks, (a, b) -> (int) a.getPageNumbers() - (int) b.getPageNumbers());

        return localBooks;
    }

    public List<Book> getBooksSortedByPageNumberAscWithStream(boolean asc) {
        List<Book> localBooks = getBooks();
            localBooks.stream().sorted(asc
                    ? Comparator.comparing(Book::getPageNumbers)
                    : Comparator.comparing(Book::getPageNumbers).reversed());


            return localBooks;

    }

    public List<Book> getBooksSortedByTitle(boolean asc) {
        List<Book> localBooks = getBooks();

        if (asc) {
            Collections.sort(localBooks, Book.COMPARE_BY_TITLE_ASC);
        } else {
            Collections.sort(localBooks, Book.COMPARE_BY_TITLE_DESC);
        }

        return localBooks;
    }

    public List<Book> getBooksSortedByAuthorAge(boolean asc) {
        List<Book> localBooks = getBooks();

        if (asc) {
            Collections.sort(localBooks, Book.COMPARE_BY_AUTHOR_AGE);
        } else {
            //Collections.sort(localBooks, Person.COMPARE_BY_AGE_DESC);
        }

        return localBooks;
    }

    public List<Book> getBooksSortedByAuthorName(boolean asc) {
        List<Book> localBooks = getBooks();

        if (asc) {
            //Collections.sort(localBooks, Book.COMPARE_BY_AUTHOR_AGE);
        } else {
            //Collections.sort(localBooks, Person.COMPARE_BY_AGE_DESC);
        }

        return localBooks;
    }


    public List<Person> extractAuthors(List<Book> books) {
        ArrayList<Person> people = new ArrayList<>();

        for (int i=0; i < books.size(); i++) {
            people.add(books.get(i).getAuthor());
        }
        return people;
    }


    public List<String> extractAuthorNames(List<Person> people) {
        ArrayList<String> names = new ArrayList<String>();

        for (int i=0; i < people.size(); i++) {
            names.add(people.get(i).getName());
        }
        return names;
    }

    public List<String> extractAuthorNamesWithStream(List<Book> books) {
        return books.stream()
                .map(b -> b.getAuthor().getName())
                .collect(Collectors.toList());

    }
}

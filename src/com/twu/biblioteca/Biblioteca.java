package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<Book> bookList;
    private UserInputStream userInputStream;
    private List<Book> checkedOutBooks;

    public Biblioteca(PrintStream printStream, List<Book> books, UserInputStream userInputStream, List<Book> checkedOutBooks) {
        this.printStream = printStream;
        this.bookList = books;
        this.userInputStream = userInputStream;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void listBooks() {
        int counter = 1;
        for (Book book : bookList) {
            this.printStream.println(counter + ". " + book);
            counter++;
        }
    }

    public void checkoutBook() {
        String bookTitle = userInputStream.getUserInput();
        Book book;

        if ((book = retrieveBookByTitleFromBookList(bookTitle)) != null) {
            moveBookToCheckedOutBooks(book);
            printStream.println("Thank you! Enjoy the book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    private void moveBookToCheckedOutBooks(Book book) {
        Book checkedOutBook = bookList.remove(bookList.indexOf(book));
        checkedOutBooks.add(checkedOutBook);
    }

    private Book retrieveBookByTitleFromBookList(String bookTitle) {
        Book tempBook = new Book(bookTitle, "", "");

        for (Book book : bookList) {
            if (book.equals(tempBook)) {
                return book;
            }
        }

        return null;
    }

    public void returnBook() {
        String bookTitle = userInputStream.getUserInput();
        Book book;

        if ((book = retrieveBookByTitleFromCheckedoutList(bookTitle)) != null) {
            moveBookToBookList(book);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private void moveBookToBookList(Book book) {
        Book returnedBook = checkedOutBooks.remove(checkedOutBooks.indexOf(book));
        bookList.add(returnedBook);
    }

    private Book retrieveBookByTitleFromCheckedoutList(String bookTitle) {
        Book tempBook = new Book(bookTitle, "", "");

        if (checkedOutBooks.size() == 0 ) return null;

        for (Book book : checkedOutBooks) {
            if (book.equals(tempBook)) {
                return book;
            }
        }

        return null;
    }
}


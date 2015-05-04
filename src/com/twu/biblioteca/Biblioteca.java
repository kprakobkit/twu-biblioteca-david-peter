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

        if ((book = retrieveBookByTitle(bookTitle)) != null) {
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

    private Book retrieveBookByTitle(String bookTitle) {
        Book tempBook = new Book(bookTitle, "", "");

        for (Book book : bookList) {
            if (book.equals(tempBook)) {
                return book;
            }
        }

        return null;
    }
}


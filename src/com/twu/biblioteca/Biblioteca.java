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
    private List<Movie> movieList;

    public Biblioteca(PrintStream printStream, List<Book> books, UserInputStream userInputStream, List<Book> checkedOutBooks, List<Movie> movieList) {
        this.printStream = printStream;
        this.bookList = books;
        this.userInputStream = userInputStream;
        this.checkedOutBooks = checkedOutBooks;
        this.movieList = movieList;
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

        if ((book = retrieveBookByTitleFromList(bookTitle, bookList)) != null) {
            moveBookBetweenLists(book, bookList, checkedOutBooks);
            printStream.println("Thank you! Enjoy the book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void returnBook() {
        String bookTitle = userInputStream.getUserInput();
        Book book;

        if ((book = retrieveBookByTitleFromList(bookTitle, checkedOutBooks)) != null) {
            moveBookBetweenLists(book, checkedOutBooks, bookList);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private void moveBookBetweenLists(Book book, List<Book> fromList, List<Book> toList) {
        Book checkedOutBook = fromList.remove(fromList.indexOf(book));
        toList.add(checkedOutBook);
    }

    private Book retrieveBookByTitleFromList(String bookTitle, List<Book> bookList) {
        Book tempBook = new Book(bookTitle, "", "");

        for (Book book : bookList) {
            if (book.equals(tempBook)) return book;
        }

        return null;
    }

    public void listMovies() {
        int counter = 1;
        for (Movie movie : movieList) {
            this.printStream.println(counter + ". " + movie);
            counter++;
        }
    }
}


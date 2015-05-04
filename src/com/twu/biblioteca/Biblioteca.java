package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<LibraryItem> bookList;
    private UserInputStream userInputStream;
    private List<LibraryItem> checkedOutLibraryItems;
    private List<LibraryItem> movieList;

    public Biblioteca(PrintStream printStream, List<LibraryItem> books, UserInputStream userInputStream, List<LibraryItem> checkedOutLibraryItems, List<LibraryItem> movieList) {
        this.printStream = printStream;
        this.bookList = books;
        this.userInputStream = userInputStream;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
        this.movieList = movieList;
    }

    public void listBooks() {
        int counter = 1;
        for (LibraryItem book : bookList) {
            this.printStream.println(counter + ". " + book);
            counter++;
        }
    }

    public void checkoutBook() {
        String bookTitle = userInputStream.getUserInput();
        LibraryItem book;

        if ((book = retrieveBookByTitleFromList(bookTitle, bookList)) != null) {
            moveBookBetweenLists(book, bookList, checkedOutLibraryItems);
            printStream.println("Thank you! Enjoy the book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void returnBook() {
        String bookTitle = userInputStream.getUserInput();
        LibraryItem book;

        if ((book = retrieveBookByTitleFromList(bookTitle, checkedOutLibraryItems)) != null) {
            moveBookBetweenLists(book, checkedOutLibraryItems, bookList);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private void moveBookBetweenLists(LibraryItem book, List<LibraryItem> fromList, List<LibraryItem> toList) {
        LibraryItem checkedOutBook = fromList.remove(fromList.indexOf(book));
        toList.add(checkedOutBook);
    }

    private LibraryItem retrieveBookByTitleFromList(String bookTitle, List<LibraryItem> bookList) {
        Book tempBook = new Book(bookTitle, "", "");

        for (LibraryItem book : bookList) {
            if (book.equals(tempBook)) return book;
        }

        return null;
    }

    public void listMovies() {
        int counter = 1;
        for (LibraryItem movie : movieList) {
            this.printStream.println(counter + ". " + movie);
            counter++;
        }
    }

    public void checkoutMovie() {
    }
}


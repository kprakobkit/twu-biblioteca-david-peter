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
        list(bookList);
    }

    public void listMovies() {
        list(movieList);
    }

    public void checkoutBook() {
        String bookTitle = userInputStream.getUserInput();
        LibraryItem book = new Book(bookTitle, "", "");

        processCheckout(book, bookList);
    }

    public void checkoutMovie() {
        String movieTitle = userInputStream.getUserInput();
        LibraryItem movie = new Movie(movieTitle, "", "", 1);

        processCheckout(movie, movieList);
    }

    public void returnBook() {
        String bookTitle = userInputStream.getUserInput();
        LibraryItem book = new Book(bookTitle, "", "");

        if (checkedOutLibraryItems.contains(book)) {
            book = checkedOutLibraryItems.get(checkedOutLibraryItems.indexOf(book));
            moveBookBetweenLists(book, checkedOutLibraryItems, bookList);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("The is not a valid book to return.");
        }
    }

    private void processCheckout(LibraryItem libraryItem, List<LibraryItem> list) {
        if (list.contains(libraryItem)) {
            libraryItem = list.get(list.indexOf(libraryItem));
            moveBookBetweenLists(libraryItem, list, checkedOutLibraryItems);
            printStream.println("Thank you! Enjoy the " + libraryItem.getClass().getSimpleName().toLowerCase() + ".");
        } else {
            printStream.println("The " + libraryItem.getClass().getSimpleName().toLowerCase() + " is not available.");
        }
    }

    private void list(List<LibraryItem> itemList) {
        int counter = 1;
        for (LibraryItem libraryItem : itemList) {
            printStream.println(counter + ". " + libraryItem);
            counter++;
        }
    }

    private void moveBookBetweenLists(LibraryItem book, List<LibraryItem> fromList, List<LibraryItem> toList) {
        LibraryItem checkedOutBook = fromList.remove(fromList.indexOf(book));
        toList.add(checkedOutBook);
    }
}


package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<LibraryItem> bookList;
    private List<LibraryItem> checkedOutLibraryItems;
    private List<LibraryItem> movieList;

    public Biblioteca(PrintStream printStream, List<LibraryItem> books, List<LibraryItem> checkedOutLibraryItems, List<LibraryItem> movieList) {
        this.printStream = printStream;
        this.bookList = books;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
        this.movieList = movieList;
    }

    public void listBooks() {
        list(bookList);
    }

    public void listMovies() {
        list(movieList);
    }

    public void checkoutBook(LibraryItem book) {
        checkout(book, bookList);
    }

    public void checkoutMovie(LibraryItem movie) {
        checkout(movie, movieList);

    }

    public void returnBook(LibraryItem book) {
        if (checkedOutLibraryItems.contains(book)) {
            book = checkedOutLibraryItems.get(checkedOutLibraryItems.indexOf(book));
            moveItemBetweenLists(book, checkedOutLibraryItems, bookList);
            printStream.println("Thank you for returning the book.");
            return;
        }

        printStream.println("The is not a valid book to return.");
    }

    private void list(List<LibraryItem> itemList) {
        int counter = 1;
        for (LibraryItem libraryItem : itemList) {
            printStream.println(counter + ". " + libraryItem);
            counter++;
        }
    }

    private void checkout(LibraryItem libraryItem, List<LibraryItem> list) {
        if (list.contains(libraryItem)) {
            libraryItem = list.get(list.indexOf(libraryItem));
            moveItemBetweenLists(libraryItem, list, checkedOutLibraryItems);
            printStream.println("Thank you! Enjoy the " + libraryItem.getClass().getSimpleName().toLowerCase() + ".");
            return;
        }

        printStream.println("The " + libraryItem.getClass().getSimpleName().toLowerCase() + " is not available.");
    }

    private void moveItemBetweenLists(LibraryItem item, List<LibraryItem> fromList, List<LibraryItem> toList) {
        LibraryItem checkedOutBook = fromList.remove(fromList.indexOf(item));
        toList.add(checkedOutBook);
    }
}


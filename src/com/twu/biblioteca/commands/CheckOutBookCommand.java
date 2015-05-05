package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.LibraryItem;
import com.twu.biblioteca.UserInputStream;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/1/15.
 */
public class CheckOutBookCommand implements Command {
    private Biblioteca biblioteca;
    private UserInputStream userInputStream;
    private PrintStream printStream;

    public CheckOutBookCommand(Biblioteca biblioteca, PrintStream printStream, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
    }

    @Override
    public void execute() {
        printStream.println("Input the book you would like to checkout? - please enter the title of the book.");
        String bookTitle = userInputStream.getUserInput();

        LibraryItem book = new Book(bookTitle, "", "");
        biblioteca.checkoutBook(book);
    }
}

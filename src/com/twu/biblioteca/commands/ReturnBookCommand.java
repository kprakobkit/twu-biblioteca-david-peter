package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.UserInputStream;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/3/15.
 */
public class ReturnBookCommand implements Command {

    private Biblioteca biblioteca;
    private PrintStream printStream;

    public ReturnBookCommand(Biblioteca biblioteca, PrintStream printStream, UserInputStream userInputStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("What book are you returning? - please enter the title of the book.");
        biblioteca.returnBook(new Book("","",""));
    }
}

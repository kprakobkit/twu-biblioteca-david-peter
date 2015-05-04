package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/3/15.
 */
public class ReturnBookCommand implements Command {

    private Biblioteca biblioteca;
    private PrintStream printStream;

    public ReturnBookCommand(Biblioteca biblioteca, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("What book are you returning? - please enter the title of the book.");
        biblioteca.returnBook();
    }
}

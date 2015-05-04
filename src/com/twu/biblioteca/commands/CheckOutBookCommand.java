package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.commands.Command;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/1/15.
 */
public class CheckOutBookCommand implements Command {
    private Biblioteca biblioteca;
    private PrintStream printStream;

    public CheckOutBookCommand(Biblioteca biblioteca, PrintStream printStream) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        printStream.println("Input the book you would like to checkout? - please enter the title of the book.");
        biblioteca.checkoutBook();
    }
}

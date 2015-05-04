package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/3/15.
 */
public class CheckOutMovieCommand implements Command {
    private Biblioteca biblioteca;
    private PrintStream printStream;

    public CheckOutMovieCommand(Biblioteca biblioteca, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Input the movie you would like to checkout? - please enter the title of the movie.");
        biblioteca.checkoutMovie();
    }
}

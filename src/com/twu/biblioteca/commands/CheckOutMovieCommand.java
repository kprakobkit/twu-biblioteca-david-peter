package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;

import java.io.PrintStream;

/**
 * Created by kprakobk on 5/3/15.
 */
public class CheckOutMovieCommand implements Command {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private UserInputStream userInputStream;

    public CheckOutMovieCommand(Biblioteca biblioteca, PrintStream printStream, UserInputStream userInputStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.userInputStream = userInputStream;
    }

    @Override
    public void execute() {
        printStream.println("Input the movie you would like to checkout? - please enter the title of the movie.");
        String name = userInputStream.getUserInput();

        LibraryItem movie = new Movie(name, "", "", 1);
        biblioteca.checkoutMovie(movie);
    }
}

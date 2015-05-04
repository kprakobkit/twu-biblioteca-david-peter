package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by kprakobk on 5/3/15.
 */
public class ReturnBookCommand implements Command {

    private Biblioteca biblioteca;

    public ReturnBookCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.returnBook();
    }
}

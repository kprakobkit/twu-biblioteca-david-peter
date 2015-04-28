package com.twu.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Array;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private Array[] bookList;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
        this.bookList = new Array[2];
    }

    public void startUserInterface() {
        this.printStream.println("Welcome to Biblioteca!");
        this.listBooks();
    }

    public void listBooks() {
//        this.printStream.println("1.");
//        this.printStream.println("2.");
        for (int i = 0; i < bookList.length; ++i) {
            this.printStream.println(i+1 + ". " + bookList[i]);
        }
    }

    public Array[] getBookList() {
        return bookList;
    }
}


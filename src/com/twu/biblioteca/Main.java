package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final PrintStream out = System.out;

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(out, books(), new UserInputStream(), new ArrayList<LibraryItem>(), movies());
        Menu menu = new Menu(out, biblioteca, new UserInputStream(), initializeMapMenu(biblioteca));

        menu.start();
    }

    private static List<LibraryItem> movies() {
        List<LibraryItem> movies = new ArrayList<LibraryItem>();
        movies.add(new Movie("Guardians of the Galaxy", "2014", "Marvel", 9));
        movies.add(new Movie("Grand Budapest Hotel", "2013", "Wes Anderson", 10));
        movies.add(new Movie("Whiplash", "2014", "Someone", 7));

        return movies;
    }

    private static Map<String, Command> initializeMapMenu(Biblioteca biblioteca) {
        Map<String, Command> mapMenuCommand = new HashMap<String, Command>();
        mapMenuCommand.put("List Books", new ListBooksCommand(biblioteca));
        mapMenuCommand.put("Checkout Book", new CheckOutBookCommand(biblioteca, out));
        mapMenuCommand.put("Return Book", new ReturnBookCommand(biblioteca, out));
        mapMenuCommand.put("List Movies", new ListMoviesCommand(biblioteca));
        mapMenuCommand.put("Checkout Movie", new CheckOutMovieCommand(biblioteca, out));

        return mapMenuCommand;
    }

    private static List<LibraryItem> books() {
        List<LibraryItem> books = new ArrayList<LibraryItem>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        return books;
    }
}

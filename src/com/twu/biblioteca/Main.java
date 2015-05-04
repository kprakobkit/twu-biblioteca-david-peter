package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out, books(), new UserInputStream(), new ArrayList<Book>(), movies());
        Menu menu = new Menu(System.out, biblioteca, new UserInputStream(), initializeMapMenu(biblioteca));

        menu.start();
    }

    private static List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Guardians of the Galaxy", "2014", "Marvel", 9));
        movies.add(new Movie("Grand Budapest Hotel", "2013", "Wes Anderson", 10));
        movies.add(new Movie("Whiplash", "2014", "Someone", 7));

        return movies;
    }

    private static Map<String, Command> initializeMapMenu(Biblioteca biblioteca) {
        Map<String, Command> mapMenuCommand = new HashMap<String, Command>();
        mapMenuCommand.put("List Books", new ListBooksCommand(biblioteca));
        mapMenuCommand.put("Checkout Book", new CheckOutBookCommand(biblioteca, System.out));
        mapMenuCommand.put("Return Book", new ReturnBookCommand(biblioteca, System.out));
        mapMenuCommand.put("List Movies", new ListMoviesCommand(biblioteca));

        return mapMenuCommand;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        return books;
    }
}

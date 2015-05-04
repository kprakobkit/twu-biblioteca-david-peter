package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<LibraryItem> books;
    private Book book1;
    private UserInputStream userInputStream;
    private ArrayList checkedOutLibraryItems;
    private Book book2;
    private Movie movie1;
    private Movie movie2;
    private ArrayList<LibraryItem> movies;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        book1 = new Book("Title", "Author", "Year");
        book2 = new Book("Title2", "Author", "Year");
        movie1 = new Movie("Movie1", "Year", "Director", 10);
        movie2 = new Movie("Movie2", "Year2", "Director", 10);

        books = new ArrayList<LibraryItem>();
        books.add(book1);

        checkedOutLibraryItems = new ArrayList<LibraryItem>();
        checkedOutLibraryItems.add(book2);

        movies = new ArrayList<LibraryItem>();
        movies.add(movie1);
        movies.add(movie2);

        biblioteca = new Biblioteca(printStream, books, userInputStream, checkedOutLibraryItems, movies);
    }

    @Test
    public void shouldPrintEachBook() {
        biblioteca.listBooks();

        verify(printStream, times(books.size())).println(anyString());
    }

    @Test
    public void shouldPrintBookObjectsFromListBooks(){
        biblioteca.listBooks();

        verify(printStream).println(contains(book1.toString()));
    }

    @Test
    public void shouldGetUserInputOnCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Title");

        biblioteca.checkoutBook();

        verify(userInputStream).getUserInput();
    }

    @Test
    public void shouldCheckoutSelectedBook() {
        when(userInputStream.getUserInput()).thenReturn("Title");

        biblioteca.checkoutBook();

        assertTrue(checkedOutLibraryItems.contains(book1));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulBookCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Title");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulBookCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Foo");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("That book is not available."));
    }

    @Test
    public void shouldReturnSelectedBook() {
        when(userInputStream.getUserInput()).thenReturn("Title2");

        biblioteca.returnBook();

        assertTrue(books.contains(book2));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulReturn() {
        when(userInputStream.getUserInput()).thenReturn("Title2");

        biblioteca.returnBook();

        verify(printStream).println(contains("Thank you for returning the book."));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulReturn() {
        when(userInputStream.getUserInput()).thenReturn("Foo");

        biblioteca.returnBook();

        verify(printStream).println(contains("That is not a valid book to return."));
    }

    @Test
    public void shouldListEveryMovie() {
        biblioteca.listMovies();

        verify(printStream, atLeast(1)).println(contains("Movie"));
    }

    @Test
    public void shouldCheckoutSelectedMovie() {
        when(userInputStream.getUserInput()).thenReturn("Movie1");

        biblioteca.checkoutMovie();

        assertTrue(checkedOutLibraryItems.contains(movie1));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulMovieCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Movie1");

        biblioteca.checkoutMovie();

        verify(printStream).println(contains("Thank you! Enjoy the movie."));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulMovieCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Foo");

        biblioteca.checkoutMovie();

        verify(printStream).println("The movie is not available.");
    }
}

package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<Book> books;
    private Book book1;
    private UserInputStream userInputStream;
    private ArrayList checkedOutBooks;
    private Book book2;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        book1 = new Book("Title", "Author", "Year");
        book2 = new Book("Title2", "Author", "Year");
        books = new ArrayList<Book>();
        books.add(book1);
        checkedOutBooks = new ArrayList<Book>();
        checkedOutBooks.add(book2);
        biblioteca = new Biblioteca(printStream, books, userInputStream, checkedOutBooks);
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

        assertTrue(checkedOutBooks.contains(book1));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulCheckout() {
        when(userInputStream.getUserInput()).thenReturn("Title");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulCheckout() {
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
}

package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
    }


    @Test
    public void shouldWelcomeUserOnStartTest() {
        biblioteca.startUserInterface();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldCallPrintLnForEachBook() {
        biblioteca.listBooks();

        verify(printStream, times(biblioteca.getBookList().length)).println(anyString());
    }

    @Test
    public void shouldPrintListOfBooksAfterWelcomeMessageTest() {
        shouldWelcomeUserOnStartTest();

        verify(printStream, times(biblioteca.getBookList().length + 1 )).println(anyString());
    }

}

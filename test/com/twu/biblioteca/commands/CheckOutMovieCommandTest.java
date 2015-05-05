package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.UserInputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kprakobk on 5/3/15.
 */
public class CheckOutMovieCommandTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private CheckOutMovieCommand checkOutMovieCommand;
    private UserInputStream userInputStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInputStream = mock(UserInputStream.class);
        checkOutMovieCommand = new CheckOutMovieCommand(biblioteca, printStream, userInputStream);
    }

    @Test
    public void shouldCheckoutMovieOnExecution() {
        String name = "Movie Name";
        when(userInputStream.getUserInput()).thenReturn(name);

        checkOutMovieCommand.execute();

        verify(biblioteca).checkoutMovie(new Movie(name, "", "", 1));
    }

    @Test
    public void shouldAskUserWhatBookTheyWantToCheckout() {
        checkOutMovieCommand.execute();

        verify(printStream).println("Input the movie you would like to checkout? - please enter the title of the movie.");
    }
}
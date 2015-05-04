package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/3/15.
 */
public class CheckOutMovieCommandTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private CheckOutMovieCommand checkOutMovieCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        checkOutMovieCommand = new CheckOutMovieCommand(biblioteca, printStream);
    }

    @Test
    public void shouldCheckoutMovieOnExecution() {
        checkOutMovieCommand.execute();

        verify(biblioteca).checkoutMovie();
    }

    @Test
    public void shouldAskUserWhatBookTheyWantToCheckout() {
        checkOutMovieCommand.execute();

        verify(printStream).println("Input the movie you would like to checkout? - please enter the title of the movie.");
    }
}
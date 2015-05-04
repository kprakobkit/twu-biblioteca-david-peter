package com.twu.biblioteca;

import com.twu.biblioteca.commands.CheckOutBookCommand;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kprakobk on 5/1/15.
 */
public class CheckOutBookCommandTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private CheckOutBookCommand checkOutBookCommand;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        checkOutBookCommand = new CheckOutBookCommand(biblioteca, printStream);
    }

    @Test
    public void shouldCheckoutBookWhenExecute() {
        checkOutBookCommand.execute();

        verify(biblioteca).checkoutBook();
    }

    @Test
    public void shouldAskUserWhatBookTheyWantToCheckout() {
        checkOutBookCommand.execute();

        verify(printStream).println("Input the book you would like to checkout? - please enter the title of the book.");
    }
}
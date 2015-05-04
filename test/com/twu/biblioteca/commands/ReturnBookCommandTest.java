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
public class ReturnBookCommandTest {

    private ReturnBookCommand returnBookCommand;
    private Biblioteca biblioteca;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        returnBookCommand = new ReturnBookCommand(biblioteca, printStream);
    }

    @Test
    public void shouldReturnBookOnExecute() {
        returnBookCommand.execute();

        verify(biblioteca).returnBook();
    }
    @Test
    public void shouldAskUserWhatBookToReturn() {
        returnBookCommand.execute();

        verify(printStream).println("What book are you returning? - please enter the title of the book.");
    }
}
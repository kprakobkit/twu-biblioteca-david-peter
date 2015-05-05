package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
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
public class ReturnBookCommandTest {

    private ReturnBookCommand returnBookCommand;
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private UserInputStream userInputStream;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        userInputStream = mock(UserInputStream.class);
        returnBookCommand = new ReturnBookCommand(biblioteca, printStream, userInputStream);
    }

    @Test
    public void shouldReturnBookOnExecute() {
        String title = "Title";
        when(userInputStream.getUserInput()).thenReturn(title);

        returnBookCommand.execute();

        verify(biblioteca).returnBook(new Book(title, "", ""));
    }
    @Test
    public void shouldAskUserWhatBookToReturn() {
        returnBookCommand.execute();

        verify(printStream).println("What book are you returning? - please enter the title of the book.");
    }
}
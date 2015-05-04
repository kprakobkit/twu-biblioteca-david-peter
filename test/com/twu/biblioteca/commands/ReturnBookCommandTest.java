package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/3/15.
 */
public class ReturnBookCommandTest {

    private ReturnBookCommand returnBookCommand;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        returnBookCommand = new ReturnBookCommand(biblioteca);
    }

    @Test
    public void shouldReturnBookOnExecute() {
        returnBookCommand.execute();

        verify(biblioteca).returnBook();
    }
}
package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/1/15.
 */
public class ListBooksCommandTest {

    @Test
    public void shouldListBooksOnExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca);

        listBooksCommand.execute();

        verify(biblioteca).listBooks();
    }


}
package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/3/15.
 */
public class ListMoviesCommandTest {

    private Biblioteca biblioteca;
    private ListMoviesCommand listMovieCommand;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        listMovieCommand = new ListMoviesCommand(biblioteca);
    }

    @Test
    public void shouldListMovieOnExecute() {
        listMovieCommand.execute();

        verify(biblioteca).listMovies();
    }
}
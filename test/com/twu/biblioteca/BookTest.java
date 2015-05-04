package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("Title", "Author", "Year");

    }

    @Test
    public void toStringShouldPrintTitleAuthorAndYearPublished() {
        assertThat(book.toString(), allOf(containsString("Title"), containsString("Author"), containsString("Year")));
    }

    @Test
    public void toStringShouldFormatOutputToUseColumns() {
        assertEquals("Title                                             |Author              |Year", book.toString());
    }

    @Test
    public void shouldCompareBooksByTitle() {
        assertEquals(book, new Book("Title", "Author", "Year"));
    }
}

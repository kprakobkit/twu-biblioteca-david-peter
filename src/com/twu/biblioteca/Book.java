package com.twu.biblioteca;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Book extends LibraryItem {

    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%-50s|%-20s|%-4s", title, author, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return !(title != null ? !title.equals(book.title) : book.title != null);

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}

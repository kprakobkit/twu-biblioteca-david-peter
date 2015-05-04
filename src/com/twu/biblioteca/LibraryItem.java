package com.twu.biblioteca;

/**
 * Created by kprakobk on 5/3/15.
 */
public class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;

        LibraryItem that = (LibraryItem) o;

        return !(title != null ? !title.equals(that.title) : that.title != null);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}

package org.library.rest.api.component.book.controller;

public class FilterableBook {

    private String filterTitle;

    private String filterIsbn;

    public String getFilterTitle() {
        return filterTitle;
    }

    public void setFilterTitle(String filterTitle) {
        this.filterTitle = filterTitle;
    }

    public String getFilterIsbn() {
        return filterIsbn;
    }

    public void setFilterIsbn(String filterIsbn) {
        this.filterIsbn = filterIsbn;
    }
}

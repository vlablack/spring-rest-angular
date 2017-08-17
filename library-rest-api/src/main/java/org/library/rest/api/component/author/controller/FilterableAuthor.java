package org.library.rest.api.component.author.controller;

public class FilterableAuthor {

    private String filterFirstName;

    private String filterLastName;

    public String getFilterFirstName() {
        return filterFirstName;
    }

    public void setFilterFirstName(String filterFirstName) {
        this.filterFirstName = filterFirstName;
    }

    public String getFilterLastName() {
        return filterLastName;
    }

    public void setFilterLastName(String filterLastName) {
        this.filterLastName = filterLastName;
    }
}

package org.library.rest.api.component.book.controller;


import org.library.rest.api.common.controller.GenericCRUDController;
import org.library.rest.api.common.service.GenericCRUDService;
import org.library.rest.api.component.book.service.BookService;
import org.library.rest.api.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController extends GenericCRUDController<Book> {

    static final String BASE_URL = "/books";

    @Autowired
    private BookService bookService;

    @Override
    protected GenericCRUDService<Book> getService() {
        return bookService;
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }
}

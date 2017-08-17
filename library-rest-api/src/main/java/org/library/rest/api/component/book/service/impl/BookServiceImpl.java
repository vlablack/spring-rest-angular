package org.library.rest.api.component.book.service.impl;

import org.library.rest.api.common.service.GenericCRUDServiceImpl;
import org.library.rest.api.component.book.controller.FilterableBook;
import org.library.rest.api.component.book.repository.BookSpecification;
import org.library.rest.api.component.book.service.BookService;
import org.library.rest.api.domain.Book;
import org.library.rest.api.component.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends GenericCRUDServiceImpl<Book, FilterableBook> implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    protected JpaRepository<Book, Long> getRepository() {
        return bookRepository;
    }

    @Override
    protected Specification<Book> getSpecification(FilterableBook filterable) {
        return new BookSpecification(filterable);
    }
}

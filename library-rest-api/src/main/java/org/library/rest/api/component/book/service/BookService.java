package org.library.rest.api.component.book.service;

import org.library.rest.api.common.service.GenericCRUDService;
import org.library.rest.api.component.book.controller.FilterableBook;
import org.library.rest.api.domain.Book;

public interface BookService extends GenericCRUDService<Book, FilterableBook> {

}

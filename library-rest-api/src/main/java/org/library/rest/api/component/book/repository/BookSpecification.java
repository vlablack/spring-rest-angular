package org.library.rest.api.component.book.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.library.rest.api.common.repository.BaseGenericSpecification;
import org.library.rest.api.component.book.controller.FilterableBook;
import org.library.rest.api.domain.Book;
import org.springframework.util.StringUtils;

public class BookSpecification extends BaseGenericSpecification<Book, FilterableBook> {

    public BookSpecification(FilterableBook filterable) {
        super(filterable);
    }

    @Override
    public void buildSpecification(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb, FilterableBook filterable) {
        String filterIsbn = filterable.getFilterIsbn();
        if (StringUtils.hasText(filterIsbn)) {
            equal(root.get("isbn"), filterIsbn);
        }

        containsIgnoreCase(root.get("title"), filterable.getFilterTitle());
    }
}

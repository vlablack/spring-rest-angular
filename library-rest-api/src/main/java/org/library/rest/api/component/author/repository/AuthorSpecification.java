package org.library.rest.api.component.author.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.library.rest.api.common.repository.BaseGenericSpecification;
import org.library.rest.api.component.author.controller.FilterableAuthor;
import org.library.rest.api.domain.Author;

public class AuthorSpecification extends BaseGenericSpecification<Author, FilterableAuthor> {

    public AuthorSpecification(FilterableAuthor filterable) {
        super(filterable);
    }

    @Override
    public void buildSpecification(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb, FilterableAuthor filterable) {
        containsIgnoreCase(root.get("firstName"), filterable.getFilterFirstName());
        containsIgnoreCase(root.get("lastName"), filterable.getFilterLastName());
    }
}

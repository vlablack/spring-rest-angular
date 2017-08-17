package org.library.rest.api.common.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public abstract class BaseGenericSpecification<T, F> implements Specification<T> {

    private List<Predicate> predicates;

    private Root<T> root;

    private CriteriaBuilder criteriaBuilder;

    private final F filterable;

    public BaseGenericSpecification(F filterable) {
        this.filterable = filterable;
    }

    @Override
    public final Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        this.root = root;
        this.criteriaBuilder = criteriaBuilder;
        predicates = new ArrayList<>();
        buildSpecification(root, query, criteriaBuilder, filterable);
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    public abstract void buildSpecification(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, F filterable);

    protected final void containsIgnoreCase(Path<String> path, String filterValue) {
        if (StringUtils.hasText(filterValue)) {
            Expression<String> lowerCaseExp = criteriaBuilder.lower(path);
            predicate(criteriaBuilder.like(lowerCaseExp, SearchHelper.buildLikePattern(filterValue), criteriaBuilder.literal(SearchHelper.ESCAPE_CHAR)));
        }
    }

    protected void equal(Path<?> path, Object filterValue) {
        if (filterValue != null) {
            predicate(criteriaBuilder.equal(path, filterValue));
        }
    }

    protected final void predicate(Predicate predicate) {
        predicates.add(predicate);
    }
}

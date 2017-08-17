package org.library.rest.api.common.service;

import org.library.rest.api.common.exception.LibraryApiException;
import org.library.rest.api.domain.HasId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public abstract class GenericReadServiceImpl<E extends HasId, F> implements GenericReadService<E, F> {

    protected abstract JpaRepository<E, Long> getRepository();

    protected abstract Specification<E> getSpecification(F filterable);

    @Override
    public E findById(Long id) {
        try {
            return getRepository().findOne(id);
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

    @Override
    public Page<E> findAllByFilter(Pageable pageable, F filterable) {
        try {
            Specification<E> specification = getSpecification(filterable);
            Pageable pageableWithSort = getPageRequest(pageable);
            if (specification != null && hasSpecificationExecutor()) {
                return getJpaSpecificationExecutor().findAll(specification, pageableWithSort);
            } else {
                return getRepository().findAll(pageableWithSort);
            }
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

    protected Pageable getPageRequest(Pageable pageable) {
        int pageNumber = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        if (pageable.getSort() != null) {
            // Use tik column for getting a stable sorting order
            return new PageRequest(pageNumber, pageable.getPageSize(), pageable.getSort().and(new Sort("id")));
        } else {
            return new PageRequest(pageNumber, pageable.getPageSize(), Direction.ASC, getSort());
        }
    }

    protected String[] getSort() {
        return new String[] { "id" };
    }

    @SuppressWarnings("unchecked")
    private JpaSpecificationExecutor<E> getJpaSpecificationExecutor() {
        if (hasSpecificationExecutor()) {
            return (JpaSpecificationExecutor<E>) getRepository();
        } else {
            return null;
        }
    }

    private boolean hasSpecificationExecutor() {
        return getRepository() instanceof JpaSpecificationExecutor<?>;
    }
}

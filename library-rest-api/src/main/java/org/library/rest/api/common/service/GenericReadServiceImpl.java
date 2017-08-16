package org.library.rest.api.common.service;

import org.library.rest.api.common.exception.LibraryApiException;
import org.library.rest.api.domain.HasId;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericReadServiceImpl<E extends HasId> implements GenericReadService<E> {

    protected abstract JpaRepository<E, Long> getRepository();

    @Override
    public E findById(Long id) {
        try {
            return getRepository().findOne(id);
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

}

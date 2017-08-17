package org.library.rest.api.common.service;

import org.library.rest.api.domain.HasId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericReadService<E extends HasId, F> {

    E findById(Long id);

    Page<E> findAllByFilter(Pageable pageable, F filterable);

}

package org.library.rest.api.common.service;

import org.library.rest.api.domain.HasId;

public interface GenericReadService<E extends HasId> {

    E findById(Long id);

}

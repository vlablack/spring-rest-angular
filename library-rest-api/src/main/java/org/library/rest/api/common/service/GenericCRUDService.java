package org.library.rest.api.common.service;

import org.library.rest.api.common.model.BaseEntityDto;
import org.library.rest.api.common.model.ServiceResult;
import org.library.rest.api.domain.HasId;

public interface GenericCRUDService<E extends HasId, F> extends GenericReadService<E, F> {

    ServiceResult<E> save(E entity);

    ServiceResult<E> update(Long id, E entity);

    ServiceResult<BaseEntityDto> delete(Long id);

}

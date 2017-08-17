package org.library.rest.api.common.service;

import org.library.rest.api.common.exception.LibraryApiException;
import org.library.rest.api.common.model.BaseEntityDto;
import org.library.rest.api.common.model.ServiceResult;
import org.library.rest.api.domain.HasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericCRUDServiceImpl<E extends HasId, F> extends GenericReadServiceImpl<E, F> implements GenericCRUDService<E, F> {

    @Transactional(rollbackFor = LibraryApiException.class)
    @Override
    public ServiceResult<E> save(E entity) {
        try {
            getRepository().save(entity);
            return ServiceResult.created(entity);
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

    @Transactional(rollbackFor = LibraryApiException.class)
    @Override
    public ServiceResult<E> update(Long id, E entity) {
        try {
            entity.setId(id);
            if (getRepository().exists(id)) {
                getRepository().save(entity);
                return ServiceResult.updated(entity);
            } else {
                return ServiceResult.notExist(entity);
            }
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

    @Transactional(rollbackFor = LibraryApiException.class)
    @Override
    public ServiceResult<BaseEntityDto> delete(Long id) {
        try {
            if (getRepository().exists(id)) {
                getRepository().delete(id);
                return ServiceResult.deleted(new BaseEntityDto(id));
            } else {
                return ServiceResult.notExist(new BaseEntityDto(id));
            }
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

}

package org.library.rest.api.common.service;

import org.library.rest.api.common.exception.LibraryApiException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericCRUDServiceImpl<EntityType> implements GenericCRUDService<EntityType> {

    protected abstract JpaRepository<EntityType, Long> getRepository();

    @Transactional(rollbackFor = LibraryApiException.class)
    @Override
    public void save(EntityType entity) {
        try {
            getRepository().save(entity);
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }

    @Override
    public EntityType findById(Long id) {
        try {
            return getRepository().findOne(id);
        } catch (Exception e) {
            throw new LibraryApiException(e);
        }
    }
}

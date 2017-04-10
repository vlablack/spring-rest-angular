package org.library.rest.api.common.service;

public interface GenericCRUDService<EntityType> {

    void save(EntityType entity);

    EntityType findById(Long id);

}

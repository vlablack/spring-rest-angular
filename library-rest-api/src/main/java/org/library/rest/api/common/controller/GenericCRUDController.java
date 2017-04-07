package org.library.rest.api.common.controller;

import org.library.rest.api.common.service.GenericCRUDService;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class GenericCRUDController<EntityType> {

    protected abstract GenericCRUDService<EntityType> getService();

    protected abstract String getBaseUrl();

    @RequestMapping(value = "/insert")
    public String insertEntity() {
        return "OK";
    }

}

package org.library.rest.api.common.controller;

import org.library.rest.api.common.exception.LibraryApiException;
import org.library.rest.api.common.model.ResponseModel;
import org.library.rest.api.common.service.GenericCRUDService;
import org.library.rest.api.common.service.GenericReadService;
import org.library.rest.api.domain.HasId;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public abstract class GenericReadController<E extends HasId, F> {

    protected abstract GenericReadService<E, F> getService();

    protected abstract String getBaseUrl();

    @RequestMapping(params = "/{id}", method = RequestMethod.GET)
    public ResponseModel getEntityById(@PathVariable("id") Long id) {
        try {
            return ResponseModel.ok(getService().findById(id));
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseModel findByFilter(F filterable, Pageable pageable) {
        try {
            return ResponseModel.ok(getService().findAllByFilter(pageable, filterable));
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

}

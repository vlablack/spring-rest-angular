package org.library.rest.api.common.controller;

import org.library.rest.api.common.exception.LibraryApiException;
import org.library.rest.api.common.exception.UnsupportedServiceResultTypeException;
import org.library.rest.api.common.model.BaseEntityDto;
import org.library.rest.api.common.model.ResponseModel;
import org.library.rest.api.common.model.ServiceResult;
import org.library.rest.api.common.service.GenericCRUDService;
import org.library.rest.api.domain.HasId;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ResponseBody
public abstract class GenericCRUDController<E extends HasId> {

    protected abstract GenericCRUDService<E> getService();

    protected abstract String getBaseUrl();

    @RequestMapping(params = "/{id}", method = RequestMethod.GET)
    public ResponseModel getEntityById(@PathVariable("id") Long id) {
        try {
            return ResponseModel.ok(getService().findById(id));
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseModel insertEntity(@Valid @RequestBody E entity, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseModel.validationError(errors);
        }
        try {
            ServiceResult<E> result = getService().save(entity);
            return chooseResponseModel(result);
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

    @RequestMapping(params = "/{id}", method = RequestMethod.PUT)
    public ResponseModel updateEntity(@PathVariable("id") Long id, @Valid @RequestBody E entity, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseModel.validationError(errors);
        }
        try {
            ServiceResult<E> result = getService().update(id, entity);
            return chooseResponseModel(result);
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

    @RequestMapping(params = "/{id}", method = RequestMethod.DELETE)
    public ResponseModel deleteEntity(@PathVariable("id") Long id) {
        try {
            ServiceResult<BaseEntityDto> result = getService().delete(id);
            return chooseResponseModel(result);
        } catch (LibraryApiException e) {
            return ResponseModel.internalError(e);
        }
    }

    private <T> ResponseModel chooseResponseModel(ServiceResult<T> result) {
        switch (result.getResultType()) {
            case UPDATED:
                return ResponseModel.ok(result);
            case CREATED:
                return ResponseModel.ok(result);
            case DELETED:
                return ResponseModel.ok(result);
            case NOT_EXIST:
                return ResponseModel.badRequest(result);
            default:
                throw new UnsupportedServiceResultTypeException();
        }
    }

}

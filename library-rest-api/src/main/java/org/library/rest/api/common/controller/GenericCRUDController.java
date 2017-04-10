package org.library.rest.api.common.controller;

import org.library.rest.api.common.service.GenericCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericCRUDController<EntityType> {

    protected abstract GenericCRUDService<EntityType> getService();

    protected abstract String getBaseUrl();

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseModel insertEntity(@Valid @RequestBody EntityType entity, BindingResult errors) {
        if (errors.hasErrors()) {
            return new ResponseModel(HttpStatus.BAD_REQUEST, getErrorsMap(errors));
        }
        try {
            getService().save(entity);
            return new ResponseModel(HttpStatus.OK, entity);
        } catch (Exception e) {
            return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    private Map<String, List<String>> getErrorsMap(BindingResult errors) {
        Map<String, List<String>> result = new HashMap<>();
        for (ObjectError error : errors.getAllErrors()) {
            String name = error.getObjectName();
            String errorCode = error.getDefaultMessage();
            if (result.containsKey(name)) {
                result.get(name).add(errorCode);
            } else {
                List<String> errorList = new ArrayList<>();
                errorList.add(errorCode);
                result.put(name, errorList);
            }
        }
        return result;
    }

}

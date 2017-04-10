package org.library.rest.api.common.controller;

import org.library.rest.api.common.service.GenericCRUDService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
public abstract class GenericCRUDController<EntityType> {

    protected abstract GenericCRUDService<EntityType> getService();

    protected abstract String getBaseUrl();

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseModel getEntityById(@RequestParam("id") Long id) {
        try {
            return ResponseModel.ok(getService().findById(id));
        } catch (Exception e) {
            return ResponseModel.internalError(e);
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseModel insertEntity(@Valid @RequestBody EntityType entity, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseModel.validationError(getErrorsMap(errors));
        }
        try {
            getService().save(entity);
            return ResponseModel.ok(entity);
        } catch (Exception e) {
            return ResponseModel.internalError(e);
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

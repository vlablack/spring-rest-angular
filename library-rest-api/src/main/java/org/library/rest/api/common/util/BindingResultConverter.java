package org.library.rest.api.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public abstract class BindingResultConverter {

    public static Map<String, List<String>> toMap(BindingResult errors) {
        Map<String, List<String>> result = new HashMap<>();
        for (ObjectError error : errors.getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                String name = fieldError.getField();
                String errorCode = error.getDefaultMessage();
                if (result.containsKey(name)) {
                    result.get(name).add(errorCode);
                } else {
                    List<String> errorList = new ArrayList<>();
                    errorList.add(errorCode);
                    result.put(name, errorList);
                }
            }
        }
        return result;
    }

}

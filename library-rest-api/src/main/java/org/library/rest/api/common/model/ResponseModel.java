package org.library.rest.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import org.library.rest.api.common.util.BindingResultConverter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@JsonInclude(Include.NON_NULL)
public class ResponseModel implements Serializable {

    private static final long serialVersionUID = 303415770180108952L;

    private final HttpStatus status;

    private final Object content;

    private ResponseModel(HttpStatus status, Object content) {
        this.status = status;
        this.content = content;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getContent() {
        return content;
    }

    public static ResponseModel ok(Object content) {
        return new ResponseModel(HttpStatus.OK, content);
    }

    public static ResponseModel ok() {
        return ok(null);
    }

    public static ResponseModel badRequest(Object content) {
        return new ResponseModel(HttpStatus.BAD_REQUEST, content);
    }

    public static ResponseModel internalError(Exception e) {
        return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    public static ResponseModel validationError(BindingResult errors) {
        return new ResponseModel(HttpStatus.BAD_REQUEST, BindingResultConverter.toMap(errors));
    }

}

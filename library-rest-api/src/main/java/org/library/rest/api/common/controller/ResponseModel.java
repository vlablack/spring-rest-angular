package org.library.rest.api.common.controller;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResponseModel implements Serializable {

    private static final long serialVersionUID = 303415770180108952L;

    private HttpStatus status;

    private Object content;

    public ResponseModel(HttpStatus status) {
        this.status = status;
    }

    public ResponseModel(HttpStatus status, Object content) {
        this.status = status;
        this.content = content;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public static ResponseModel ok(Object content) {
        return new ResponseModel(HttpStatus.OK, content);
    }

    public static ResponseModel internalError(Exception e) {
        return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    public static ResponseModel validationError(Map<String, List<String>> errorsMap) {
        return new ResponseModel(HttpStatus.BAD_REQUEST, errorsMap);
    }

}

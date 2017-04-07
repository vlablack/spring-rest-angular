package org.library.rest.api.common.controller;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

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
}

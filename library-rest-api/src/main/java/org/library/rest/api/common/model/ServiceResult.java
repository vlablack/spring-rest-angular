package org.library.rest.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ServiceResult<T> {

    private final ServiceResultTypes resultType;

    private final T object;

    private ServiceResult(ServiceResultTypes resultType, T object) {
        this.resultType = resultType;
        this.object = object;
    }

    public ServiceResultTypes getResultType() {
        return resultType;
    }

    public T getObject() {
        return object;
    }

    public static <T> ServiceResult<T> created(T object) {
        return new ServiceResult<>(ServiceResultTypes.CREATED, object);
    }

    public static <T> ServiceResult<T> updated(T object) {
        return new ServiceResult<>(ServiceResultTypes.UPDATED, object);
    }

    public static <T> ServiceResult<T> notExist(T object) {
        return new ServiceResult<>(ServiceResultTypes.NOT_EXIST, object);
    }

    public static <T> ServiceResult<T> deleted(T object) {
        return new ServiceResult<>(ServiceResultTypes.DELETED, object);
    }

    public enum ServiceResultTypes {
        CREATED, UPDATED, DELETED, NOT_EXIST
    }

}

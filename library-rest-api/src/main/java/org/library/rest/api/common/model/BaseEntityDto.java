package org.library.rest.api.common.model;

public class BaseEntityDto {

    private Long id;

    public BaseEntityDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

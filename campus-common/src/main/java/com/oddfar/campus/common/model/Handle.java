package com.oddfar.campus.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Handle<T> {
    private String error;

    private T data;
}

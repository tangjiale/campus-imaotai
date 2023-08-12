package com.oddfar.campus.common.model;

@FunctionalInterface
public interface TrueConditionHandle {
    void handle(Runnable handleTrue);
}

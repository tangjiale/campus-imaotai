package com.oddfar.campus.common.model;

@FunctionalInterface
public interface ConditionHandle {
    void conditionHandle(Runnable handleTrue, Runnable handleFalse);
}

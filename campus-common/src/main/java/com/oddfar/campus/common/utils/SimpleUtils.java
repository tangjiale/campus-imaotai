package com.oddfar.campus.common.utils;


import com.oddfar.campus.common.exception.BizException;
import com.oddfar.campus.common.model.ConditionHandle;
import com.oddfar.campus.common.model.Handle;
import com.oddfar.campus.common.model.TrueConditionHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.function.Supplier;

@Slf4j
public class SimpleUtils {
    public static void throwDefaultWhenEmpty(Object object, String msg) {
        throwWhenEmpty(object, new BizException(msg));
    }

    public static void throwDefaultWhenTrue(boolean result, String msg) {
        throwWhenTrue(result, new BizException(msg));
    }

    public static void throwDefaultWhenTrue(boolean result, Supplier<String> func) {
        if (result) {
            throw new BizException(func.get());
        }
    }

    public static void throwDefaultWhenFalse(boolean result, String msg) {
        throwWhenTrue(!result, new BizException(msg));
    }

    public static void throwWhenEmpty(Object object, BizException bizException) {
        if (ObjectUtils.isEmpty(object)) {
            throw bizException;
        }
    }

    public static void throwWhenTrue(boolean result, BizException bizException) {
        if (result) {
            throw bizException;
        }
    }


    public static <T> T doSupplierWhenTrue(boolean result, Supplier<T> func) {
        if (result) {
            return func.get();
        }
        return null;
    }

    public static <T> T doSupplierWithTry(Supplier<T> func, String errorMsg) {
        try {
            return func.get();
        } catch (Exception exception) {
            log.error("error to do doSupplierWithTry:{}", exception.getMessage());
            throw new BizException(errorMsg);
        }
    }


    public static <T, E> T handleExceptionWhenFuncError(Supplier<T> func, Runnable handle, Handle<E> handleData) {
        try {
            return func.get();
        } catch (Exception e) {
            handleData.setError(e.getMessage());
            catchRunnable(handle);
            log.error("error to do handleExceptionWhenFuncError:{}", e.getMessage());
            throw e;
        }
    }

    public static void catchRunnable(Runnable handle) {
        try {
            handle.run();
        } catch (Exception e) {
            log.error("error to do catchRunnable:{}", e.getMessage());
        }
    }

    public static ConditionHandle condition(boolean result) {
        return (handleTrue, handleFalse) -> {
            if (result) {
                handleTrue.run();
            } else {
                handleFalse.run();
            }
        };
    }

    public static TrueConditionHandle trueCondition(boolean result) {
        return (handleTrue) -> {
            if (result) {
                handleTrue.run();
            }
        };
    }


}

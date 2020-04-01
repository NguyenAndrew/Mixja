package com.andyln;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Mixja {

    private Mixja() {}

    public static <E> E mix(Supplier<E> supplier) {
        return supplier.get();
    }

    public static <E> E eix(Callable<E> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

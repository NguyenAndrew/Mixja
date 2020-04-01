package com.andyln;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Mixja {

    private Mixja() {}

    /**
     * Creates an object that requires additional put/add/set/etc. Use a Java Lambda to setup and return this object.
     *
     * @param supplier Any Supplier
     * @param <E> - Element returned by Supplier
     * @return Return value of Supplier
     */
    public static <E> E mix(Supplier<E> supplier) {
        return supplier.get();
    }

    /**
     * eix = checked (e)xception may be thrown m(ix). The performance of try-catch is why this method is standalone.
     *
     * @param callable Any Callable
     * @param <E> - Element returned by Callable
     * @return Return value of Callable
     */
    public static <E> E eix(Callable<E> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

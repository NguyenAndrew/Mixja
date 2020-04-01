package com.andyln;

import java.util.function.Supplier;

public class Mixja {

    private Mixja() {}

    public static <E> E mix(Supplier<E> supplier) {
        return supplier.get();
    }
}

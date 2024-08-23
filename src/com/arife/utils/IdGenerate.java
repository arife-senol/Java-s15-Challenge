package com.arife.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerate {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int generateId() {
        return counter.getAndIncrement();
    }
}

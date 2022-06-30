package com.lyl.util;

import java.io.Closeable;

import static java.util.Objects.requireNonNull;

/**

 * <p> Description :
 *
 * @author : chunhui.mch
 * @date : 2020/5/7 10:48 上午
 */

public class SetThreadName implements Closeable {

    private final String originalThreadName;

    public SetThreadName(String format, Object... args) {

        requireNonNull(format, "format is null");

        originalThreadName = Thread.currentThread().getName();

        Thread.currentThread().setName(String.format(format, args) + "-" + Thread.currentThread().getId());
    }

    @Override
    public void close() {
        Thread.currentThread().setName(originalThreadName);
    }
}
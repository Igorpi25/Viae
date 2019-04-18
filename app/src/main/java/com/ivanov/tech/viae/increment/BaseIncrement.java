package com.ivanov.tech.viae.increment;

public interface BaseIncrement<T extends Comparable> {
    T inc(T value);
}

package com.kefirkb.structures;

public interface Stack<T> {
    void push(T el) throws IndexOutOfBoundsException;

    T pop();

    boolean isEmpty();
}

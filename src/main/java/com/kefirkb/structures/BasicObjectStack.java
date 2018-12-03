package com.kefirkb.structures;

public class BasicObjectStack<T> implements Stack<T> {

    private int size;
    private int currentSize;
    private T[] container;

    @SuppressWarnings("unchecked")
    public BasicObjectStack(int size) {
        this.size = size;
        this.container = (T[]) new Object[size];
    }

    public BasicObjectStack() {
        this(32);
    }

    @Override
    public void push(T el) {
        container[currentSize++] = el;
    }

    @SuppressWarnings("unchecked")
    private void recreateContainer() {
        if (currentSize >= size) {
            size <<= 1;
            recreateContainer();
        }
        T[] newContainer = (T[]) new Object[size];
        System.arraycopy(container, 0, newContainer, 0, container.length);
        container = newContainer;
    }

    @Override
    public T pop() throws IndexOutOfBoundsException {
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T el = container[currentSize - 1];
        container[currentSize-- - 1] = null;
        return el;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}

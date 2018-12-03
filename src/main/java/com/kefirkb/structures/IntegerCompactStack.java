package com.kefirkb.structures;

public class IntegerCompactStack implements Stack<Integer> {
    private static final long ZERO = 0x00000000_00000000L;
    private static final byte INT_SIZE = 32;

    private long[] container;
    private int internalMaxSize;
    private int currentSize;

    public IntegerCompactStack() {
        this(32);
    }

    public IntegerCompactStack(int initialCapacity) {
        this.internalMaxSize = (initialCapacity << 1) + 1;
        container = new long[internalMaxSize];
    }

    @Override
    public void push(Integer el) throws IndexOutOfBoundsException {
        if (currentSize >= internalMaxSize) {
            internalMaxSize <<= 1;
            recreateContainer();
        }
        container[currentSize >> 1] |= (ZERO | el) << ((currentSize++ & 1) == 0 ? 0 : INT_SIZE);
    }

    @Override
    public Integer pop() throws IndexOutOfBoundsException{
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        long box = container[(currentSize - 1) >> 1];
        int el = (currentSize & 1) != 0 ? (int) box : (int) (box >> INT_SIZE);
        currentSize--;
        return el;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void recreateContainer() {
        long[] newContainer = new long[internalMaxSize];
        System.arraycopy(container, 0, newContainer, 0, container.length);
        container = newContainer;
    }

}

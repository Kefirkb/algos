package com.kefirkb.structures;

public class ShortCompactStack implements Stack<Short> {
    private static final long ZERO = 0x0000_0000_0000_0000L;

    private long[] container;
    private int internalMaxSize;
    private int currentSize;

    private static final byte[] OFFSET_TABLE = new byte[4];
    static {
        OFFSET_TABLE[0] = 0;
        OFFSET_TABLE[1] = 16;
        OFFSET_TABLE[2] = 32;
        OFFSET_TABLE[3] = 48;
    }

    public ShortCompactStack() {
        this(32);
    }

    public ShortCompactStack(int initialCapacity) {
        this.internalMaxSize = (initialCapacity >> 2) + 1;
        container = new long[internalMaxSize];
    }

    @Override
    public void push(Short el) throws IndexOutOfBoundsException {
        if (currentSize >= internalMaxSize) {
            internalMaxSize <<= 2;
            recreateContainer();
        }
        long converted = 0xFFFF & el;
        container[currentSize >> 2] |= converted << (OFFSET_TABLE[((currentSize++ & 3))]);
    }

    @Override
    public Short pop() throws IndexOutOfBoundsException{
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        long box = container[(currentSize - 1) >> 2];
        return (short)(ZERO | (box >> (OFFSET_TABLE[(((currentSize-- - 1) & 3))])));
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

package com.kefirkb.structures;

public class ByteCompactStack implements Stack<Byte> {
    private static final long ZERO = 0x0000_0000_0000_0000L;

    private long[] container;
    private int internalMaxSize;
    private int currentSize;

    private static final byte[] OFFSET_TABLE = new byte[8];

    static {
        OFFSET_TABLE[0] = 0;
        OFFSET_TABLE[1] = 8;
        OFFSET_TABLE[2] = 16;
        OFFSET_TABLE[3] = 24;
        OFFSET_TABLE[4] = 32;
        OFFSET_TABLE[5] = 40;
        OFFSET_TABLE[6] = 48;
        OFFSET_TABLE[7] = 56;
    }

    public ByteCompactStack() {
        this(32);
    }

    public ByteCompactStack(int initialCapacity) {
        this.internalMaxSize = (initialCapacity >> 3) + 1;
        container = new long[internalMaxSize];
    }

    @Override
    public void push(Byte el) throws IndexOutOfBoundsException {
        if (currentSize >= internalMaxSize) {
            internalMaxSize <<= 3;
            recreateContainer();
        }
        long converted = 0xFF & el;
        container[currentSize >> 3] |= converted << (OFFSET_TABLE[((currentSize++ & 7))]);
    }

    @Override
    public Byte pop() throws IndexOutOfBoundsException {
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        long box = container[(currentSize - 1) >> 3];
        return (byte) (ZERO | (box >> (OFFSET_TABLE[(((currentSize-- - 1) & 7))])));
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

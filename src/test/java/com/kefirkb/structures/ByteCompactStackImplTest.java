package com.kefirkb.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ByteCompactStackImplTest {
    private ByteCompactStack stack;


    @Before
    public void initData(){
        stack = new ByteCompactStack(4);
    }

    @Test
    public void testPushPop() {
        stack.push((byte)-2);
        stack.push((byte)3);
        stack.push((byte)-4);
        stack.push((byte)-5);
        stack.push((byte)-6);
        stack.push((byte)7);
        stack.push((byte)-8);
        Assert.assertEquals(-8, (byte) stack.pop());
        Assert.assertEquals(7, (byte) stack.pop());
        Assert.assertEquals(-6, (byte) stack.pop());
        Assert.assertEquals(-5, (byte) stack.pop());
        Assert.assertEquals(-4, (byte) stack.pop());
        Assert.assertEquals(3, (byte) stack.pop());
        Assert.assertEquals(-2, (byte) stack.pop());
    }

}

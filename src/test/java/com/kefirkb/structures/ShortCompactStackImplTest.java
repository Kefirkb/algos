package com.kefirkb.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ShortCompactStackImplTest {
    private ShortCompactStack stack;


    @Before
    public void initData(){
        stack = new ShortCompactStack(4);
    }

    @Test
    public void testPushPop() {
        stack.push((short)-2);
        stack.push((short)3);
        stack.push((short)-4);
        stack.push((short)-5);
        stack.push((short)-6);
        stack.push((short)7);
        stack.push((short)-8);
        Assert.assertEquals(-8, (short) stack.pop());
        Assert.assertEquals(7, (short) stack.pop());
        Assert.assertEquals(-6, (short) stack.pop());
        Assert.assertEquals(-5, (short) stack.pop());
        Assert.assertEquals(-4, (short) stack.pop());
        Assert.assertEquals(3, (short) stack.pop());
        Assert.assertEquals(-2, (short) stack.pop());
    }

}

package com.kefirkb.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IntegerCompactStackImplTest {
    private IntegerCompactStack stack;


    @Before
    public void initData(){
        stack = new IntegerCompactStack(6);
    }

    @Test
    public void testPushPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(-6);
        stack.push(7);
        stack.push(Integer.MIN_VALUE);
        stack.push(9);
        stack.push(10);

        Assert.assertEquals(10, (int) stack.pop());
        Assert.assertEquals(9, (int) stack.pop());
        Assert.assertEquals(Integer.MIN_VALUE, (int) stack.pop());
        Assert.assertEquals(7, (int) stack.pop());
        Assert.assertEquals(-6, (int) stack.pop());
        Assert.assertEquals(5, (int) stack.pop());
        Assert.assertEquals(4, (int) stack.pop());
        Assert.assertEquals(3, (int) stack.pop());
        Assert.assertEquals(2, (int) stack.pop());
        Assert.assertEquals(1, (int) stack.pop());
    }
}

package com.kefirkb.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CharCompactStackImplTest {
    private CharCompactStack stack;


    @Before
    public void initData(){
        stack = new CharCompactStack(4);
    }

    @Test
    public void testPushPop() {
        stack.push('4');
        stack.push('h');
        stack.push('=');
        stack.push('g');
        stack.push('x');
        stack.push('t');
        stack.push('@');
        Assert.assertEquals('@', (char) stack.pop());
        Assert.assertEquals('t', (char) stack.pop());
        Assert.assertEquals('x', (char) stack.pop());
        Assert.assertEquals('g', (char) stack.pop());
        Assert.assertEquals('=', (char) stack.pop());
        Assert.assertEquals('h', (char) stack.pop());
        Assert.assertEquals('4', (char) stack.pop());
    }

}

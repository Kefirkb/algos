package com.kefirkb.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BasicObjectStackTest {
    private BasicObjectStack<Object> stack;
    private Object[] objects;

    @Before
    public void initData(){
        stack = new BasicObjectStack<>(10);
        objects = new Object[10];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
        }
    }

    @Test
    public void testPushPop() {
        int i = 0;
        stack.push(objects[i++]);
        stack.push(objects[i++]);
        stack.push(objects[i++]);
        stack.push(objects[i]);

        Assert.assertEquals(objects[i--], stack.pop());
        Assert.assertEquals(objects[i--], stack.pop());
        Assert.assertEquals(objects[i--], stack.pop());
        Assert.assertEquals(objects[i], stack.pop());
    }

}

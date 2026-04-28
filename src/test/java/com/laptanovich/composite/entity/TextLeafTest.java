package com.laptanovich.composite.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextLeafTest {
    @Test
    public void getType() {
        TextLeaf leaf = new TextLeaf('X', TextComponentType.SYMBOL);
        assertEquals(TextComponentType.SYMBOL, leaf.getType());
        assertEquals("X", leaf.toString());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove_exception() {
        TextLeaf leaf = new TextLeaf('X', TextComponentType.SYMBOL);
        leaf.remove(new TextLeaf('Y', TextComponentType.SYMBOL));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void get_exception() {
        TextLeaf leaf = new TextLeaf('X', TextComponentType.SYMBOL);
        leaf.get(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set_exception() {
        TextLeaf leaf = new TextLeaf('X', TextComponentType.SYMBOL);
        leaf.set(0, new TextLeaf('Y', TextComponentType.SYMBOL));
    }

    @Test
    public void size_isOne() {
        TextLeaf leaf = new TextLeaf('X', TextComponentType.SYMBOL);
        assertEquals(1, leaf.size());
    }
}
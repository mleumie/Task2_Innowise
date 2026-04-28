package com.laptanovich.composite.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCompositeTest {
    @Test
    public void add_get_size() {
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        TextLeaf leaf1 = new TextLeaf('A', TextComponentType.SYMBOL);
        TextLeaf leaf2 = new TextLeaf('B', TextComponentType.SYMBOL);
        composite.add(leaf1);
        composite.add(leaf2);
        assertEquals(2, composite.size());
        assertSame(leaf1, composite.get(0));
        assertSame(leaf2, composite.get(1));
    }

    @Test
    public void remove() {
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        TextLeaf leaf = new TextLeaf('A', TextComponentType.SYMBOL);
        composite.add(leaf);
        assertEquals(1, composite.size());
        composite.remove(leaf);
        assertEquals(0, composite.size());
    }

    @Test
    public void set() {
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        TextLeaf leaf1 = new TextLeaf('A', TextComponentType.SYMBOL);
        TextLeaf leaf2 = new TextLeaf('B', TextComponentType.SYMBOL);
        composite.add(leaf1);
        composite.set(0, leaf2);
        assertSame(leaf2, composite.get(0));
    }

    @Test
    public void toString_test() {
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        composite.add(new TextLeaf('A', TextComponentType.SYMBOL));
        composite.add(new TextLeaf('B', TextComponentType.SYMBOL));
        assertEquals("AB", composite.toString());
    }
}
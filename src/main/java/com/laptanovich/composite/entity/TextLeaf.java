package com.laptanovich.composite.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.Iterator;

public class TextLeaf extends TextComponent {
    private static final Logger logger = LogManager.getLogger(TextLeaf.class);
    private final char value;

    public TextLeaf(char character, TextComponentType type) {
        super(type);
        this.value = character;
    }

    @Override
    public void add(TextComponent component) {
        logger.warn("Can't add to a leaf component");
        throw new UnsupportedOperationException("Can't add to a leaf component");
    }

    @Override
    public void remove(TextComponent component) {
        logger.warn("Can't remove from a leaf component");
        throw new UnsupportedOperationException("Can't remove from a leaf component");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public int count() {
        return 1;
    }
}

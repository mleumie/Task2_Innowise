package com.laptanovich.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Collections;
import java.util.Iterator;

public class TextLeaf extends TextComponent {
    private static final Logger logger = LogManager.getLogger();
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
    public TextComponent get(int i) {
        logger.warn("Can't get from a leaf component");
        throw new UnsupportedOperationException("Can't get from a leaf component");
    }

    @Override
    public void set(int i, TextComponent component) {
        logger.warn("Can't set in a leaf component");
        throw new UnsupportedOperationException("Can't set in a leaf component");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return Collections.emptyIterator();
    }
}

package com.laptanovich.composite.entity;

import java.util.List;

public abstract class TextComponent implements Iterable<TextComponent>{
    private final TextComponentType type;

    public TextComponent(TextComponentType type) {
        this.type = type;
    }

    public TextComponentType getType() {
        return type;
    }

    public abstract void add(TextComponent component);

    public abstract void remove(TextComponent component);

    public abstract TextComponent get(int i);

    public abstract void set(int i, TextComponent component);

    public abstract int size();

    public abstract String toString();
}

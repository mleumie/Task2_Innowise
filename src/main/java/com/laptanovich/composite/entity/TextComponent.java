package com.laptanovich.composite.entity;

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

    public abstract String toString();

    public abstract int count();
}

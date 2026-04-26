package com.laptanovich.composite.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextComposite extends TextComponent {
    private final List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type) {
        super(type);
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : components) {
            sb.append(component.toString());
            if (component.getType() == TextComponentType.WORD) {
                sb.append(" ");
            }
            if (component.getType() == TextComponentType.PARAGRAPH) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return components.iterator();
    }

    @Override
    public int count() {
        int sum = 0;

    }
}

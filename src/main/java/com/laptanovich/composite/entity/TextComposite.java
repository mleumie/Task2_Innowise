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
    public TextComponent get(int i) {
        return components.get(i);
    }

    @Override
    public void set(int i, TextComponent component) {
        components.set(i, component);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        TextComponentType prevType = null;
        for (TextComponent component : components) {
            if ((prevType == TextComponentType.WORD || prevType == TextComponentType.LEXEME)
                    && component.getType() != TextComponentType.PUNCTUATION) {
                sb.append(" ");
            }
            sb.append(component.toString());
            if (component.getType() == TextComponentType.PARAGRAPH) {
                sb.append("\n");
            }
            prevType = component.getType();
        }
        return sb.toString();
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return components.iterator();
    }
}

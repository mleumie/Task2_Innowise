package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;

public class TextParser extends AbstractTextParser {
    private static final String PARAGRAPH_DELIMITER = "\\t| {4,}";

    @Override
    public TextComponent parse(String text) {
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.strip().split(PARAGRAPH_DELIMITER);
        for (String data : paragraphs) {
            TextComponent component = getNextParser().parse(data);
            textComposite.add(component);
        }
        return textComposite;
    }
}

package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;

public class WordParser extends AbstractTextParser {
    @Override
    public TextComponent parse(String text) {
        TextComponent wordComponent = new TextComposite(TextComponentType.WORD);
        for (char character : text.toCharArray()) {
            TextComponent charComponent = getNextParser().parse(String.valueOf(character));
            wordComponent.add(charComponent);
        }
        return wordComponent;
    }
}

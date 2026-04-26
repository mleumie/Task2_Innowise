package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;

public class LexemeParser extends AbstractTextParser {
    private static final String WORD_DELIMITER = "\\s+";

    @Override
    public TextComponent parse(String text) {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        String[] words = text.strip().split(WORD_DELIMITER);
        for (String word : words) {
            TextComponent wordComponent = getNextParser().parse(word);
            lexeme.add(wordComponent);
        }
        return lexeme;
    }
}

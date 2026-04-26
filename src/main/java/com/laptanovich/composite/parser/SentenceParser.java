package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;

public class SentenceParser extends AbstractTextParser {
    private static final String LEXEME_DELIMITER = "\\s+";

    @Override
    public TextComponent parse(String text) {
        TextComponent sentence = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = text.strip().split(LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = getNextParser().parse(lexeme);
            sentence.add(lexemeComponent);
        }
        return sentence;
    }
}

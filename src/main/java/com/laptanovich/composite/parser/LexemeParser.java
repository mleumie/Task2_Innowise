package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;
import com.laptanovich.composite.entity.TextLeaf;

public class LexemeParser extends AbstractTextParser {
    private static final String WORD_DELIMITER = "(?<=\\p{Punct})|(?=\\p{Punct})|\\s+";

    @Override
    public TextComponent parse(String text) {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        String[] words = text.strip().split(WORD_DELIMITER);
        for (String word : words) {
            if (word.matches("\\p{Punct}")) {
                TextComponent punctuationComponent = new TextLeaf(word.charAt(0), TextComponentType.PUNCTUATION);
                lexeme.add(punctuationComponent);
            }
            else {
                TextComponent wordComponent = getNextParser().parse(word);
                lexeme.add(wordComponent);
            }
        }
        return lexeme;
    }
}

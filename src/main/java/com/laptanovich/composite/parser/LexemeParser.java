package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;
import com.laptanovich.composite.entity.TextLeaf;

public class LexemeParser extends AbstractTextParser {
    private static final String WORD_DELIMITER = "(?<=\\p{Punct})|(?=\\p{Punct})|\\s+";
    private static final String WORD_REGEX = "[\\p{L}']+|\\p{Punct}";
    private static final String PUNCTUATION_DELIMITER = "\\p{Punct}";

    @Override
    public TextComponent parse(String text) {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        String[] words = text.strip().split(WORD_DELIMITER);
        for (String w : words) {
            String word = w.strip();
            if (word.matches(PUNCTUATION_DELIMITER)) {
                TextComponent punctuationComponent = new TextLeaf(word.charAt(0), TextComponentType.PUNCTUATION);
                lexeme.add(punctuationComponent);
            }
            else if (word.matches(WORD_REGEX)) {
                TextComponent wordComponent = getNextParser().parse(word);
                lexeme.add(wordComponent);
            }
        }
        return lexeme;
    }
}

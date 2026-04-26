package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;
import com.laptanovich.composite.entity.TextLeaf;

public class PunctuationParser extends AbstractTextParser {
    private static final String PUNCTUATION_DELIMITER = "\\p{Punct}";

    @Override
    public TextComponent parse(String text) {
        TextComponent punctuationComponent = new TextComposite(TextComponentType.PUNCTUATION);
        for (char symbol : text.toCharArray()) {
            if (String.valueOf(symbol).matches(PUNCTUATION_DELIMITER)) {
                TextComponent symbolComponent = new TextLeaf(symbol, TextComponentType.PUNCTUATION);
                punctuationComponent.add(symbolComponent);
            }
        }
        return punctuationComponent;
    }
}

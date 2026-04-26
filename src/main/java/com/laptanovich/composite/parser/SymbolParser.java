package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;
import com.laptanovich.composite.entity.TextLeaf;

public class SymbolParser extends AbstractTextParser {
    @Override
    public TextComponent parse(String text) {
        TextComponent symbol = new TextComposite(TextComponentType.SYMBOL);
        for (char character : text.toCharArray()) {
            TextComponent charComponent = new TextLeaf(character, TextComponentType.SYMBOL);
            symbol.add(charComponent);
        }
        return symbol;
    }
}

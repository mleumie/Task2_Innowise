package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SymbolParserTest {
    @Test
    public void parse() {
        SymbolParser symbolParser = new SymbolParser();
        String text = "brat_summ6r";
        TextComponentTest result = symbolParser.parse(text);
        assertEquals(text.length(), result.size());
        for (int i = 0; i < text.length(); i++) {
            assertEquals(TextComponentType.SYMBOL, result.get(i).getType());
            assertEquals(String.valueOf(text.charAt(i)), result.get(i).toString());
        }
    }
}
package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordParserTest {
    @Test
    public void parse() {
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();
        wordParser.setNextParser(symbolParser);
        String text = "Incomprehensibility";
        TextComponentTest result = wordParser.parse(text);
        assertEquals(text.length(), result.size());
        for (int i = 0; i < text.length()-1; i++) {
            assertEquals(TextComponentType.SYMBOL, result.get(i).getType());
            assertEquals(text.charAt(i), result.get(i).toString().charAt(0));
        }
    }
}

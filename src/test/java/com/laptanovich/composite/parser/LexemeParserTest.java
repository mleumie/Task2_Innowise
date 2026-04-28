package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexemeParserTest {
    @Test
    public void parse() {
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);
        TextComponentTest result = lexemeParser.parse("Hello, world!");
        assertEquals(4, result.size());
        assertEquals(TextComponentType.WORD, result.get(0).getType());
        assertEquals(TextComponentType.PUNCTUATION, result.get(1).getType());
        assertEquals(TextComponentType.WORD, result.get(2).getType());
        assertEquals(TextComponentType.PUNCTUATION, result.get(3).getType());
        assertEquals("Hello", result.get(0).toString());
        assertEquals(",", result.get(1).toString());
        assertEquals("world", result.get(2).toString());
        assertEquals("!", result.get(3).toString());
    }
}

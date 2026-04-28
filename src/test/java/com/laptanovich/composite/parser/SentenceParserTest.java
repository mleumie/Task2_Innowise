package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SentenceParserTest {
    @Test
    public void parse() {
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);
        TextComponentTest result = paragraphParser.parse("Hello, world! Bye. Test?");
        assertEquals(3, result.size());
        assertEquals(TextComponentType.SENTENCE, result.get(0).getType());
        assertEquals(TextComponentType.SENTENCE, result.get(1).getType());
        assertEquals(TextComponentType.SENTENCE, result.get(2).getType());
        assertEquals("Hello, world!", result.get(0).toString());
        assertEquals("Bye.", result.get(1).toString());
        assertEquals("Test?", result.get(2).toString());
    }
}

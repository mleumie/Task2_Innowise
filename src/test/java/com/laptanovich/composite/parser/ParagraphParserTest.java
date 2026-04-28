package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParagraphParserTest {
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
        TextComponentTest result = paragraphParser.parse("Hello, world!\n World, bye");
        assertEquals(2, result.size());
        TextComponentTest firstParagraph = result.get(0);
        assertEquals(TextComponentType.SENTENCE, firstParagraph.getType());
        TextComponentTest secondParagraph = result.get(1);
        assertEquals(TextComponentType.SENTENCE, secondParagraph.getType());
    }
}

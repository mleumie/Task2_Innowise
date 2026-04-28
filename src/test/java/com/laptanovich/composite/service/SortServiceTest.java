package com.laptanovich.composite.service;

import com.laptanovich.composite.parser.*;
import com.laptanovich.composite.service.impl.SortServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortServiceTest {
    private SortServiceImpl sortService;
    private TextParser textParser;

    @Before
    public void setUp() {
        sortService = new SortServiceImpl();
        textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);
    }

    @Test
    public void countLetter() {
        TextComponentTest root = textParser.parse("Aaa Bb a, A? A");
        int count = sortService.countLetter(root, 'A');
        assertEquals(6, count);
    }

    @Test
    public void sortSentences_byCount() {
        TextComponentTest root = textParser.parse("Aaa? Bb! AaaA.");
        List<TextComponentTest> sorted = sortService.sortSentences(root, 'A');
        assertEquals("Bb!", sorted.get(0).toString());
        assertEquals("Aaa?", sorted.get(1).toString());
        assertEquals("AaaA.", sorted.get(2).toString());
    }
}

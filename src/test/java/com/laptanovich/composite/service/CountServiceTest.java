package com.laptanovich.composite.service;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.parser.*;
import com.laptanovich.composite.service.impl.CountServiceImpl;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class CountServiceTest {
    private CountServiceImpl countService;
    private TextParser textParser;

    @Before
    public void setUp() {
        countService = new CountServiceImpl();
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
    public void countDuplicate_duplicateWords() {
        TextComponent root = textParser.parse("Word, word duplicate");
        int count = countService.countDuplicate(root);
        assertEquals(1, count);
    }

    @Test
    public void countDuplicate_noDuplicateWords() {
        TextComponent root = textParser.parse("Unique words");
        int count = countService.countDuplicate(root);
        assertEquals(0, count);
    }

}

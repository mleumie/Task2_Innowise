package com.laptanovich.composite.service;

import com.laptanovich.composite.parser.*;
import com.laptanovich.composite.service.impl.SwapServiceImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SwapServiceTest {
    @Test
    public void swapLexemes_twoWords() {
        SwapServiceImpl swapService = new SwapServiceImpl();
        TextParser textParser = new TextParser();
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
        String text = "Hello world! Bye test.";
        TextComponentTest root = textParser.parse(text);
        swapService.swapLexemes(root);
        TextComponentTest firstSentence = root.get(0).get(0);
        assertEquals("world! Hello", firstSentence.toString().strip());
        TextComponentTest secondSentence = root.get(0).get(1);
        assertEquals("test. Bye", secondSentence.toString().strip());
    }
}
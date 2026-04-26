package com.laptanovich.composite;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.exception.CustomException;
import com.laptanovich.composite.parser.LexemeParser;
import com.laptanovich.composite.parser.ParagraphParser;
import com.laptanovich.composite.parser.SentenceParser;
import com.laptanovich.composite.parser.SymbolParser;
import com.laptanovich.composite.parser.TextParser;
import com.laptanovich.composite.parser.WordParser;
import com.laptanovich.composite.reader.TextReader;
import com.laptanovich.composite.reader.impl.TextReaderImpl;

public class Main {
    public static void main(String[] args) {
        TextReader reader = new TextReaderImpl();

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

        try {
            String text = reader.read("data/text.txt");
            TextComponent root = textParser.parse(text);
            System.out.println(root);
        } catch (CustomException e) {
            System.err.println("Read error: " + e.getMessage());
        }
    }
}
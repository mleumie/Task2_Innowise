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
import com.laptanovich.composite.service.impl.CountServiceImpl;
import com.laptanovich.composite.service.impl.SortServiceImpl;
import com.laptanovich.composite.service.impl.SwapServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {
        TextReader reader = new TextReaderImpl();
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();
        CountServiceImpl textService = new CountServiceImpl();
        SortServiceImpl textSortService = new SortServiceImpl();
        SwapServiceImpl swapService = new SwapServiceImpl();

        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);

        try {
            String text = reader.read("data/text.txt");
            TextComponent root = textParser.parse(text);
            int duplicateCount = textService.countDuplicate(root);
            logger.info(root);
            List<TextComponent> sorted = textSortService.sortSentences(root, 'I');
            logger.info("Sorted by num of I: " + sorted);
            swapService.swapLexemes(root);
            logger.info("After swap: " + root);
        } catch (CustomException e) {
            throw new CustomException("Read error", e);
        }
    }
}
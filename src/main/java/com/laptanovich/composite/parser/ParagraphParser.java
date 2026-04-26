package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComposite;

public class ParagraphParser extends AbstractTextParser {
    private static final String SENTENCE_DELIMITER = "(?<=\\.)|(?<=!)|(?<=\\?)";

    @Override
    public TextComponent parse(String text) {
        TextComponent paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = text.strip().split(SENTENCE_DELIMITER);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = getNextParser().parse(sentence);
            paragraph.add(sentenceComponent);
        }
        return paragraph;
    }
}

package com.laptanovich.composite.service.impl;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.service.SwapService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SwapServiceImpl implements SwapService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void swapLexemes(TextComponent component) {
        List<TextComponent> sentences = new ArrayList<>();
        collectSentences(component, sentences);
        for (TextComponent sentence : sentences) {
            if (sentence.size() > 1) {
                TextComponent first = sentence.get(0);
                TextComponent last = sentence.get(sentence.size() - 1);
                sentence.set(0, last);
                sentence.set(sentence.size() - 1, first);
            }
        }
        logger.info("Swapped lexemes in " + sentences.size() + "sentences");
    }

    @Override
    public void collectSentences(TextComponent component, List<TextComponent> array) {
        if (component.getType() == TextComponentType.SENTENCE) {
            array.add(component);
            return;
        }
        for (TextComponent child : component) {
            collectSentences(child, array);
        }
    }
}
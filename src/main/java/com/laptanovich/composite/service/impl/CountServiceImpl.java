package com.laptanovich.composite.service.impl;

import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.service.CountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountServiceImpl implements CountService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int countDuplicate(TextComponent component) {
        List<TextComponent> sentences = new ArrayList<>();
        collectSentences(component, sentences);
        int count = 0;
        for (TextComponent sentence : sentences) {
            Set<String> words = new HashSet<>();
            if (collectWords(sentence, words)) {
                count++;
            }
        }
        logger.info("Sentences with duplicate words: {}", count);
        return count;
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

    @Override
    public boolean collectWords(TextComponent component, Set<String> array) {
        if (component.getType() == TextComponentType.WORD) {
            String word = component.toString().toLowerCase().strip();
            return !array.add(word); //true if in array
        }
        for (TextComponent child : component) {
            if (collectWords(child, array)) {
                return true;
            }
        }
        return false;
    }
}
package com.laptanovich.composite.service.impl;

import com.laptanovich.composite.entity.TextComponent;
import com.laptanovich.composite.entity.TextComponentType;
import com.laptanovich.composite.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortServiceImpl implements SortService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<TextComponent> sortSentences(TextComponent component, char letter) {
        List<TextComponent> sentences = new ArrayList<>();
        collectSentences(component, sentences);
        sentences.sort(Comparator.comparing(s -> countLetter(s, letter)));
        logger.info("Sentences sorted by{}: {}", letter, sentences.size());
        return sentences;
    }

    @Override
    public int countLetter(TextComponent component, char letter) {
        int count = 0;
        char letterLower = Character.toLowerCase(letter);
        String text = component.toString().toLowerCase();
        for (char c : text.toCharArray()) {
            if (c == letterLower) {
                count++;
            }
        }
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
}

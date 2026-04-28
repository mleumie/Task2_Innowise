package com.laptanovich.composite.service;

import com.laptanovich.composite.entity.TextComponent;

import java.util.List;
import java.util.Set;

public interface CountService {
    int countDuplicate(TextComponent component);

    void collectSentences(TextComponent component, List<TextComponent> array);

    boolean collectWords(TextComponent component, Set<String> array);
}

package com.laptanovich.composite.service;

import com.laptanovich.composite.entity.TextComponent;

import java.util.List;

public interface SwapService {
    void swapLexemes(TextComponent component);

    void collectSentences(TextComponent component, List<TextComponent> array);
}

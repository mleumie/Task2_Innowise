package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponent;

public abstract class AbstractTextParser {
    private AbstractTextParser nextParser;

    public void setNextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    public AbstractTextParser getNextParser() {
        return nextParser;
    }

    public abstract TextComponent parse(String text);
}

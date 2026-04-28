package com.laptanovich.composite.parser;

import com.laptanovich.composite.entity.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PunctuationParserTest {
    @Test
    public void parse() {
        PunctuationParser punctuationParser = new PunctuationParser();
        String text = ",.!?";
        TextComponentTest result = punctuationParser.parse(text);
        assertEquals(text.length(), result.size());
        for (int i = 0; i < text.length(); i++) {
            assertEquals(TextComponentType.PUNCTUATION, result.get(i).getType());
            assertEquals(String.valueOf(text.charAt(i)), result.get(i).toString());
        }
    }
}
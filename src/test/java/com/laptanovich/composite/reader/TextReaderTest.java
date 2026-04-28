package com.laptanovich.composite.reader;

import com.laptanovich.composite.exception.CustomException;
import com.laptanovich.composite.reader.impl.TextReaderImpl;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class TextReaderTest {
    @Test
    public void read() throws IOException, CustomException {
        TextReader reader = new TextReaderImpl();
        String text = reader.read("src/test/resources/test.txt");
        String expected = "Abobob! Bilb7gI9pggu, uirwubUg! IUbg.";
        assertEquals(expected, text);
    }

    @Test(expected = CustomException.class)
    public void readException() throws CustomException {
        TextReaderImpl reader = new TextReaderImpl();
        reader.read("path/bebebe.txt");
    }
}
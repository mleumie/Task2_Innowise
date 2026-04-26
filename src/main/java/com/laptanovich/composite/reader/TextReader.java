package com.laptanovich.composite.reader;

import com.laptanovich.composite.exception.CustomException;

public interface TextReader {
    String read(String filePath) throws CustomException;
}

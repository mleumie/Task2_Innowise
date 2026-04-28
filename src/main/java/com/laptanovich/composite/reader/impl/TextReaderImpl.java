package com.laptanovich.composite.reader.impl;

import com.laptanovich.composite.exception.CustomException;
import com.laptanovich.composite.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReaderImpl implements TextReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String read(String filePath) throws CustomException {
        logger.info("Reading text from file: " + filePath);
        try {
            String content = Files.readString(Paths.get(filePath));
            logger.info("File successfully read: " + filePath);
            return content;
        } catch (IOException e) {
            logger.error("Error reading file: " + filePath, e);
            throw new CustomException("Could not read file at: " + filePath, e);
        }

    }
}

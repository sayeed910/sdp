package com.tahsinsayeed.sentencegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;


class Vocabulary {
    public static final Logger logger = Logger.getLogger(Vocabulary.class.getName());

    static{
        ConsoleHandler handler = new ConsoleHandler();
        logger.addHandler(handler);
    }

    private final File vocabularyStorage;

    private Vocabulary(File fileToStoreVocabulary){
        vocabularyStorage = fileToStoreVocabulary;
    }

    public void addWords(String word){
        try {
            FileWriter writer = new FileWriter(vocabularyStorage);
            writer.append(word);
        } catch (IOException e) {
            logger.severe(e.getMessage());

        }
    }

}

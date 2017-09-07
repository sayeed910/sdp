package com.tahsinsayeed.sentencegenerator;

/**
 * Created by Tahsin Sayeed on 28/08/2017.
 */
interface SentenceGenerator {
    void addWord(String word);
    String generate(int wordCount);
}

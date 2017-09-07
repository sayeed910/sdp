package com.tahsinsayeed.sentencegenerator;

import java.util.*;
import java.util.List;
import java.util.List;

class RandomSentenceGenerator implements SentenceGenerator {

    private final RandomWordSelector wordSelector;
    private List<String> internalVocabulary;

    private RandomSentenceGenerator(List<String> words, RandomWordSelector selector) {
        internalVocabulary = words;
        this.wordSelector = selector;
    }

    public static RandomSentenceGenerator withVocabularyAndSelector(List<String> vocabulary, RandomWordSelector selector) {
        return new RandomSentenceGenerator(vocabulary, selector);
    }

    public static RandomSentenceGenerator create() {

        //No. of elements in a list rarely exceed 8.
        return new RandomSentenceGenerator(new ArrayList<String>(8), RandomWordSelector.create());
    }

    public static RandomSentenceGenerator withSelector(RandomWordSelector selector) {
        return new RandomSentenceGenerator(new ArrayList<>(8), selector);
    }

    public static RandomSentenceGenerator withVocabulary(List<String> vocabulary) {
        return new RandomSentenceGenerator(vocabulary, RandomWordSelector.create());
    }


    @Override
    public void addWord(String word) {
        internalVocabulary.add(processWord(word));
    }

    private String processWord(String word){
        return word.toUpperCase();
    }

    @Override
    public String generate(int wordCount) {

        List<String> selectedWords = wordSelector.selectNWords(wordCount, internalVocabulary);
        return formSentence(selectedWords);
    }

    private String formSentence(List<String> selectedStrings) {
        StringJoiner joiner = StringJoiner.on(" ");
        return joiner.join(selectedStrings);
    }



}

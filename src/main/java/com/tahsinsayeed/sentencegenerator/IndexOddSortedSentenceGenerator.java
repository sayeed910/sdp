package com.tahsinsayeed.sentencegenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class IndexOddSortedSentenceGenerator implements SentenceGenerator {

    private final RandomWordSelector wordSelector;
    private List<String> internalVocabulary;

    private IndexOddSortedSentenceGenerator(List<String> words, RandomWordSelector selector) {
        internalVocabulary = words;
        this.wordSelector = selector;
    }

    public static IndexOddSortedSentenceGenerator create() {

        //No. of elements in a list rarely exceed 8.
        return new IndexOddSortedSentenceGenerator(new ArrayList<String>(8), RandomWordSelector.create());
    }

    public static IndexOddSortedSentenceGenerator withSelector(RandomWordSelector selector) {
        return new IndexOddSortedSentenceGenerator(new ArrayList<>(8), selector);
    }

    public static IndexOddSortedSentenceGenerator withVocabulary(List<String> vocabulary) {
        return new IndexOddSortedSentenceGenerator(vocabulary, RandomWordSelector.create());
    }

    public static IndexOddSortedSentenceGenerator withVocabularyAndSelector(List<String> vocabulary, RandomWordSelector selector) {
        return new IndexOddSortedSentenceGenerator(vocabulary, selector);
    }




    @Override
    public void addWord(String word) {
        internalVocabulary.add(processWord(word));
    }

    private String processWord(String word) {
        return word.toLowerCase();
    }

    @Override
    public String generate(int wordCount) {
        List<String> selectedStrings = wordSelector.selectNWords(wordCount, internalVocabulary);
        selectedStrings.sort(Comparator.<String>naturalOrder());
        swapOddIndexedStringsWithEvenIndexedStrings(selectedStrings);

        return formSentence(selectedStrings);
    }

    private String formSentence(List<String> selectedStrings) {
        StringJoiner joiner = StringJoiner.on(" ");
        return joiner.join(selectedStrings);
    }

    private void swapOddIndexedStringsWithEvenIndexedStrings(List<String> selectedStrings) {
        int stringCount = selectedStrings.size();

        for (int i = 1; i < stringCount; i += 2) {
            selectedStrings.add(i - 1, selectedStrings.remove(i));
        }
    }



}
package com.tahsinsayeed.sentencegenerator;

import java.util.*;

class ReversedSentenceGenerator implements SentenceGenerator {
    private final RandomIndexSelector indexSelector;
    private List<String> internalVocabulary;

    private ReversedSentenceGenerator(List<String> words, RandomIndexSelector selector) {
        internalVocabulary = words;
        this.indexSelector = selector;
    }

    public static ReversedSentenceGenerator withVocabularyAndSelector(List<String> vocabulary, RandomIndexSelector selector) {
        return new ReversedSentenceGenerator(vocabulary, selector);
    }

    public static ReversedSentenceGenerator create() {

        //No. of elements in a list rarely exceed 8.
        return new ReversedSentenceGenerator(new ArrayList<String>(8), RandomIndexSelector.create());
    }

    public static ReversedSentenceGenerator withSelector(RandomIndexSelector selector) {
        return new ReversedSentenceGenerator(new ArrayList<>(8), selector);
    }

    public static ReversedSentenceGenerator withVocabulary(List<String> vocabulary) {
        return new ReversedSentenceGenerator(vocabulary, RandomIndexSelector.create());
    }

    @Override
    public void addWord(String word) {
        internalVocabulary.add(word);
    }

    @Override
    public String generate(int wordCount) {

        List<Integer> selectedIndices = indexSelector.selectNIndices(wordCount, internalVocabulary.size());
        selectedIndices.sort(Comparator.<Integer>reverseOrder());
        List<String> selectedStrings = getWordsWithCorrespondingIndex(selectedIndices);
        reverseAndToUpperEachWord(selectedStrings);

        return makeSentence(selectedStrings);

    }

    private List<String> getWordsWithCorrespondingIndex(List<Integer> selectedIndices) {
        List<String> selectedStrings = new ArrayList<>();

        for(int index: selectedIndices)
            selectedStrings.add(internalVocabulary.get(index));

        return selectedStrings;
    }

    private void reverseAndToUpperEachWord(List<String> selectedStrings) {
        for (int i = 0; i < selectedStrings.size(); i++) {
            String str = reverseAndToUpper(selectedStrings.get(i));
            selectedStrings.set(i, str);
        }
    }

    private String reverseAndToUpper(String word){
        StringBuilder builder = new StringBuilder(word.toUpperCase());
        return builder.reverse().toString();
    }

    private String makeSentence(List<String> selectedStrings) {
        StringJoiner joiner = StringJoiner.on(" ");
        return joiner.join(selectedStrings);
    }



}



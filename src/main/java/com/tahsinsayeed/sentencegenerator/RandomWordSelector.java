package com.tahsinsayeed.sentencegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomWordSelector {
    private final Random randomNumberGenerator;

    private RandomWordSelector() {
        randomNumberGenerator = new Random();
    }


    public static RandomWordSelector create(){
        return new RandomWordSelector();
    }

    public List<String> selectNWords(int wordCount, List<String> wordsToSelectFrom){
        List<String> selectedWords = new ArrayList<>();

        for (int i = 0; i < wordCount; i++) {
            int upperBoundForSelectedIndex = wordsToSelectFrom.size();
            String selectedWord = wordsToSelectFrom.get(randomNumberGenerator.nextInt(upperBoundForSelectedIndex));
            selectedWords.add(selectedWord);
        }

        return selectedWords;
    }




}

package com.tahsinsayeed.sentencegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIndexSelector {
    private final Random randomNumberGenerator;

    private RandomIndexSelector() {
        randomNumberGenerator = new Random();
    }


    public static RandomIndexSelector create(){
        return new RandomIndexSelector();
    }

    public List<Integer> selectNIndices(int wordCount, int upperBoundOfIndices){
        List<Integer> selectedIndices = new ArrayList<>();

        for (int i = 0; i < wordCount; i++) {
            selectedIndices.add(randomNumberGenerator.nextInt(upperBoundOfIndices));
        }

        return selectedIndices;
    }


}

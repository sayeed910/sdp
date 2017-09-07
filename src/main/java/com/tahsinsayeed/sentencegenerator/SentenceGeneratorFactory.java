package com.tahsinsayeed.sentencegenerator;

import static java.util.Objects.requireNonNull;

public class SentenceGeneratorFactory {

    public SentenceGenerator create(int type) {
        requireNonNull(type, "Type of SentenceGenerator can not be null.");

        switch (type) {
            case 1:
                return RandomSentenceGenerator.create();
            case 2:
                return IndexOddSortedSentenceGenerator.create();
            case 3:
                return ReversedSentenceGenerator.create();
            default:
                throw new IllegalArgumentException("Invalid type supplied for sentence generator");

        }
    }
}

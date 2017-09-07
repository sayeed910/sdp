package com.tahsinsayeed.sentencegenerator;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tahsin Sayeed on 07/09/2017.
 */
public class StringJoiner {

    private final String delimiter;

    private StringJoiner(String delimiter) {
        this.delimiter = delimiter;
    }

    public static StringJoiner on(String delimiter){
        return new StringJoiner(delimiter);
    }



    public String join(List<String> stringsToJoin){

        //TODO: Replace fori loop with iterator

        StringBuilder builder = new StringBuilder();

        int noOfStringsToJoin = stringsToJoin.size();
        for (int i = 0; i < noOfStringsToJoin - 1; i++) {
            String str = stringsToJoin.get(i);
            builder.append(str).append(delimiter);
        }

        builder.append(stringsToJoin.get(noOfStringsToJoin - 1));

        return builder.toString();

    }
}

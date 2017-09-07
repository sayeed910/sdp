package com.tahsinsayeed.sentencegenerator;

import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;
/**
 * Created by Tahsin Sayeed on 07/09/2017.
 */
public class StringJoinerTest {

    @Test
    public void testJoin(){
        List<String> strings = new ArrayList<>(8);
        strings.add("one");
        strings.add("two");
        strings.add("three");

        StringJoiner joiner = StringJoiner.on(" ");
        assertEquals("one two three", joiner.join(strings));
    }
}

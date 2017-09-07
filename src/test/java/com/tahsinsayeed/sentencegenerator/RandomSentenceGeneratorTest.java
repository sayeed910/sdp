package com.tahsinsayeed.sentencegenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertNotEquals;


public class RandomSentenceGeneratorTest {

    private RandomSentenceGenerator generator;

    @Before
    public void setup() {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        generator = RandomSentenceGenerator.withVocabulary(strings);
    }

    /*
     * generates 100 sentences and tests to see if at least one
     * of them is different.
     */
    @Test
    public void testGenerate() throws Exception {
        Set<String> generatedSentences = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            generatedSentences.add(generator.generate(3));
        }

        assertNotEquals(1, generatedSentences.size());

    }

    @After
    public void tearDown(){
        generator = null;
    }
}
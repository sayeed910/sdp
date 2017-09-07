package com.tahsinsayeed.sentencegenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ReversedSentenceGeneratorTest {

    private ReversedSentenceGenerator generator;
    private RandomIndexSelector indexSelector;

    @Before
    public void setup() {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        indexSelector = mock(RandomIndexSelector.class);

        generator = ReversedSentenceGenerator.withVocabularyAndSelector(strings, indexSelector);
    }

    @After
    public void tearDown() throws Exception {
        generator = null;
    }

    @Test
    public void testGenerate() throws Exception {
        List<Integer> indices = new ArrayList<>();
        indices.add(2);
        indices.add(3);
        indices.add(1);


        when(indexSelector.selectNIndices(3, 4)).thenReturn(indices);

        assertEquals("RUOF EERHT OWT", generator.generate(3));

    }
}
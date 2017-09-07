package com.tahsinsayeed.sentencegenerator;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class IndexOddSortedSentenceGeneratorTest {

    @Test
    public void testGenerate() {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        RandomWordSelector selector = mock(RandomWordSelector.class);
        when(selector.selectNWords(4, strings)).thenReturn(strings);

        IndexOddSortedSentenceGenerator generator = IndexOddSortedSentenceGenerator.withVocabularyAndSelector(strings, selector);
        assertEquals("one four two three", generator.generate(4));


    }
}
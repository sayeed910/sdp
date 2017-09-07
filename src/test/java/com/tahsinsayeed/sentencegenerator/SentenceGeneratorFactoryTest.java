package com.tahsinsayeed.sentencegenerator;


import org.junit.*;
import static org.junit.Assert.*;


public class SentenceGeneratorFactoryTest {
    static SentenceGeneratorFactory factory;
    @BeforeClass
    public static void setup() {
        factory = new SentenceGeneratorFactory();
    }
    @Test
    public void testCreate_0_RandomGenerator(){
        SentenceGenerator generator = factory.create(1);
        assertEquals(generator.getClass(), RandomSentenceGenerator.class);
    }

    @Test
    public void testCreate_1_IndexOddSorted(){
        SentenceGenerator generator = factory.create(2);
        assertEquals(generator.getClass(), IndexOddSortedSentenceGenerator.class);
    }
@Test
    public void testCreate_3_Reversed(){
        SentenceGenerator generator = factory.create(3);
        assertEquals(generator.getClass(), ReversedSentenceGenerator.class);
    }
}

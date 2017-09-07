package com.tahsinsayeed.sentencegenerator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Tahsin Sayeed on 29/08/2017.
 */
public class IntegerAskerTest {
    @Test
    public void testAsk() {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        IntegerAsker asker = IntegerAsker.getAskerWithDefaultOutput(in);
        assertEquals(3, asker.ask(anyString()));
    }
}

package com.tahsinsayeed.sentencegenerator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


class StringAsker {
    private final Scanner scanner;
    private final PrintStream out;

    private StringAsker(InputStream in, PrintStream out){
        this.out = out;
        this.scanner = new Scanner(in);
    }

    static StringAsker getDefaultAsker(){
        return new StringAsker(System.in, System.out);
    }

    static StringAsker getAskerWithDefaultInput(PrintStream out){
        return new StringAsker(System.in, out);
    }
    static StringAsker getAskerWithDefaultOutput(InputStream in){
        return new StringAsker(in, System.out);
    }

    static StringAsker getAsker(InputStream in, PrintStream out){
        return new StringAsker(in, out);
    }

    String ask(String message){
        out.print(message);
        return scanner.next();
    }
}

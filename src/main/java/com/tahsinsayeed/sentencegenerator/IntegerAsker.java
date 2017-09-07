package com.tahsinsayeed.sentencegenerator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


class IntegerAsker {
    private final Scanner scanner;
    private final PrintStream out;

    private IntegerAsker(InputStream in, PrintStream out){
        this.out = out;
        this.scanner = new Scanner(in);
    }

    static IntegerAsker getDefaultAsker(){
        return new IntegerAsker(System.in, System.out);
    }

    static IntegerAsker getAskerWithDefaultInput(PrintStream out){
        return new IntegerAsker(System.in, out);
    }
    static IntegerAsker getAskerWithDefaultOutput(InputStream in){
        return new IntegerAsker(in, System.out);
    }

    static IntegerAsker getAsker(InputStream in, PrintStream out){
        return new IntegerAsker(in, out);
    }

    int ask(String message){
        out.print(message);
        return scanner.nextInt();
    }
}

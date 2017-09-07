package com.tahsinsayeed.sentencegenerator;

import java.util.Locale;

public class App {

    private SentenceGenerator generator = null;
    private IntegerAsker integerAsker;
    private SentenceGeneratorFactory generatorFactory;


    public static void main(String[] args) {
        new App().start();
    }

    App(){
        this(IntegerAsker.getDefaultAsker());
    }

    App(IntegerAsker integerAsker){
        this.integerAsker = integerAsker;
        generatorFactory = new SentenceGeneratorFactory();
    }

    private void start() {

        while (true) {
            int userChoice = showMenuAndGetUserChoice();

            createSentenceGeneratorOrExit(userChoice);

            int wordCountInSentence = integerAsker.ask("How many words in a sentence? ");
            displayGeneratedSentence(wordCountInSentence);
        }
    }

    private int showMenuAndGetUserChoice() {
        String menuAndPrompt = String.format(Locale.ENGLISH, "%s\n%s",
                "1. Random 2. Index Odd Sorted 3. Reverse Sorted 4. Exit",
                "Select Sentence Generator: ");

        return integerAsker.ask(menuAndPrompt);
    }



    private void createSentenceGeneratorOrExit(int userChoice) {
        if (userChoseToExit(userChoice)) {
            System.exit(0);
        }

        int vocabularySize = integerAsker.ask("Enter capacity for internal vocabulary");

        generator = generatorFactory.create(userChoice);

        addWordsToGeneratorsInternalVocabulary(vocabularySize, StringAsker.getDefaultAsker());
    }



    private void displayGeneratedSentence(int wordCountInSentence) {
        System.out.println("Generated Sentence: ");
        System.out.println(generator.generate(wordCountInSentence));
    }

    private void addWordsToGeneratorsInternalVocabulary(int vocabularySize, StringAsker wordAsker) {
        while (continueAddingWords(vocabularySize)) {
            generator.addWord(wordAsker.ask("Add a word to the vocabulary: "));
            vocabularySize--;
        }
    }

    private boolean continueAddingWords(int vocabularySize){
        return vocabularySize != 0;
    }



    private boolean userChoseToExit(int userChoice) {
        return userChoice == 4;
    }


}

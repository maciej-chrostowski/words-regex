package com.macchr;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var wordsRegexMatcher = new WordsRegexMatcher();
        while (true) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.equals("q1")) {
                return;
            }
            System.out.println("^^^");
            var matchingWords = wordsRegexMatcher.getMatchingWords(input)
                    .stream().filter(word -> word.length() >= 2).toList();
            matchingWords.forEach(System.out::println);
            System.out.println("$$$");
        }
    }
}

package com.macchr;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsRegexMatcher {
    private final List<String> words;

    public WordsRegexMatcher() throws IOException {
        try (var wordsFileStream = Main.class.getClassLoader().getResourceAsStream("odm.txt")) {
            var wordsOptional = Optional.ofNullable(wordsFileStream).map(stream -> {
                try {
                    return stream.readAllBytes();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).map(String::new).map(string -> Arrays.stream(string.split(",|\r\n")).map(String::strip).toList());
            words = wordsOptional.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<String> getMatchingWords(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return words.stream().filter(word -> {
                    Matcher matcher = pattern.matcher(word);
                    return matcher.find();
                }).sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
    }
}

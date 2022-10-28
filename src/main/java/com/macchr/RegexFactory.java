package com.macchr;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RegexFactory {
    public String fromLetters(Character... chars) {
        var characterToCount = Arrays.stream(chars)
                .collect(Collectors.toMap(Function.identity(), c -> Arrays.stream(chars).filter(c::equals).count()));
        return "^" + characterToCount.entrySet().stream().map(entry -> {
            if (entry.getValue().equals(1L)) {
                return negativeLookaheadForTwo(entry.getKey());
            }
            if (entry.getValue().equals(2L)) {
                return negativeLookaheadForThree(entry.getKey());
            }
            throw new RuntimeException();
        }).collect(Collectors.joining("")) + "[" +
                characterToCount.keySet().stream().map(c -> c + "")
                        .collect(Collectors.joining("")) +
                "]$";
    }

    private String negativeLookaheadForTwo(Character character) {
        return "(?!.*" + character + ".*" + character + ")";
    }

    private String negativeLookaheadForThree(Character character) {
        return "(?!.*" + character + ".*" + character + ".*" + character + ")";
    }
}

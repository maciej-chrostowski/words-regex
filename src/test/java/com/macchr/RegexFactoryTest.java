package com.macchr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegexFactoryTest {
    @InjectMocks
    private RegexFactory regexFactory;

    @Test
    void test() {
        var regex = regexFactory.fromLetters('a', 'b', 'c', 'b');
    }

}

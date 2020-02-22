package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FilePartReader fpr = new FilePartReader();
    private FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

    @Test
    public void testIfWordsOrderedAlphabetically() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test3.txt", 1, 2);
        List<String> expectedResult = Arrays.asList(
                "", "because","d", "engage", "enthusiasm", "got", "haven", "I", "I", "just",
                "Marvin", "me", "my", "one", "rather", "said", "t", "tell",
                "than", "to", "try", "Well", "wish", "you"
        );
        assertArrayEquals(expectedResult.toArray(), fwa.getWordsOrderedAlphabetically().toArray());
    }

    @Test
    public void testIfFindWordsWithSubstringOneMatch() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test3.txt", 1, 2);
        List<String> expectedResult = Arrays.asList("because");

        assertArrayEquals(expectedResult.toArray(), fwa.getWordsContainingSubstring("cause").toArray());
    }

    @Test
    public void testIfFindWordsWithSubstringNoMatch() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test3.txt", 1, 2);
        List<String> expectedResult = Collections.emptyList();

        assertArrayEquals(expectedResult.toArray(), fwa.getWordsContainingSubstring("thi").toArray());
    }

    @Test
    public void testIfFindWordsWithSubstringMoreMatch() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test3.txt", 1, 2);
        List<String> expectedResult = Arrays.asList("tell", "Well");

        assertArrayEquals(expectedResult.toArray(), fwa.getWordsContainingSubstring("ell").toArray());
    }

    @Test
    public void testIfFindPalindromesNoMatch() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test3.txt", 1, 2);
        List<String> expectedResult = Collections.emptyList();

        assertArrayEquals(expectedResult.toArray(), fwa.getStringsWhichPalindromes().toArray());
    }

    @Test
    public void testIfFindPalindromesMoreMatch() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test4.txt", 1, 6);
        List<String> expectedResult = Arrays.asList("Noon", "pop", "Refer");

        assertArrayEquals(expectedResult.toArray(), fwa.getStringsWhichPalindromes().toArray());
    }
}
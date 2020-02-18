package com.codecool.filepartreader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() throws FileNotFoundException {
        String[] words = this.fpr.readLines().split("\\W+");
        Arrays.sort(words);

        return Arrays.asList((words));
    }

    public List<String> getWordsContainingSubstring(String subString) throws FileNotFoundException {
        List<String> words = this.getWordsOrderedAlphabetically();
        String subStringLower = subString.toLowerCase();

        return words.stream().filter(w -> w.toLowerCase().contains(subStringLower))
                             .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws FileNotFoundException {
        List<String> words = this.getWordsOrderedAlphabetically();
        return words.stream().filter(this::checkIfPalindrome)
                             .collect(Collectors.toList());
    }

    private boolean checkIfPalindrome(String word) {
        String wordLower = word.toLowerCase();
        for (int i = 0; i < word.length() / 2; i++) {
            if (wordLower.charAt(i) != wordLower.charAt(word.length() - 1 - i))
                return false;
        }
        return true;
    }
}

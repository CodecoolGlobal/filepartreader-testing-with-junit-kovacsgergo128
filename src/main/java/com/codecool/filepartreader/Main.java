package com.codecool.filepartreader;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "./src/test/resources/test3.txt";
        int startLine = 1;
        int endLine = 1;

        FilePartReader fpr = new FilePartReader();
        fpr.setup(filePath, startLine, endLine);

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        System.out.println(fwa.getWordsOrderedAlphabetically().toString());
    }
}

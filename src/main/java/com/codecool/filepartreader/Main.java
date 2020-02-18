package com.codecool.filepartreader;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "./src/main/resources/test.txt";
        int startLine = 3;
        int endLine = 5;

        FilePartReader fpr = new FilePartReader();
        fpr.setup(filePath, startLine, endLine);

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        System.out.println(fwa.getWordsOrderedAlphabetically().toString());
        int x = 7 / 2;
        System.out.println(x);
    }
}

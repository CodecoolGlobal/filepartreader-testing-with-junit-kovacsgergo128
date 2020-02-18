package com.codecool.filepartreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
    }

    public void setup(String filepath, int fromLine, int toLine) {
        if (fromLine > toLine || fromLine < 1)
            throw (new IllegalArgumentException());

        this.filePath = filepath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws FileNotFoundException {
        FileReader fileReader = new FileReader(this.filePath);
        BufferedReader  br = new BufferedReader(fileReader);

        return br.lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String readLines() throws FileNotFoundException {
        String[] rows = this.read().split("\n");
        int lastRowIndexExclusive = Math.min(this.toLine, rows.length);

        return Arrays.stream(rows, this.fromLine - 1, lastRowIndexExclusive)
                .collect(Collectors.joining("\n"));
    }

}

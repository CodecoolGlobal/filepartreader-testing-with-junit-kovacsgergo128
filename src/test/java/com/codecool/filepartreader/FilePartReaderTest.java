package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader fpr = new FilePartReader();

    @Test
    public void testIfFieldsNotNull() {
        assertNotNull(fpr.getFilePath());
        assertTrue(fpr.getFromLine() > 0);
        assertTrue(fpr.getFromLine() < fpr.getToLine());
    }

    @Test
    public void testIsLowerToLineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("/test/path/to/file", 5, 1);
        });
    }

    @Test
    public void testIsLessThanOneStartLineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("/test/path/to/file", -1, 3);
        });
    }

    @Test
    public void testIsThrowsIOExceptionIfFileNotFound() {
        fpr.setup("/test/path/to/file", 1, 3);
        assertThrows(IOException.class, () -> {
            fpr.read();
        });
    }

    @Test
    public void testRead() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test1.txt", 1, 3);
        String expectedResult =
                "\"Come off it, Mr. Dent,\", he said, \"you can't win you know. You\n" +
                "can't lie in front of the bulldozer indefinitely.\" He tried to make his\n" +
                "eyes blaze fiercely but they just wouldn't do it.";

        assertEquals(expectedResult,fpr.read());
    }

    @Test
    public void testReadFirstLine() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test2.txt", 1, 1);
        String expectedResult =
                "He looked around the cracked and broken room. The wall had split";

        assertEquals(expectedResult, fpr.readLines());
    }

    @Test
    public void testReadLastLine() throws FileNotFoundException {
        fpr.setup("./src/test/resources/test2.txt", 10, 10);
        String expectedResult =
                "the world outside.";

        assertEquals(expectedResult, fpr.readLines());
    }



}
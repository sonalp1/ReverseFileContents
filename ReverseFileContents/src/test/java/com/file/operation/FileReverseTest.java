package com.file.operation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FileReverseTest {
    private FileReverse fileReverse;


    @Before
    public void setUp(){
        fileReverse = new FileReverse();
    }

    @Test
    public void testEmptyFileName() {
        assertFalse(fileReverse.createReversedFile(""));
    }

    @Test
    public void testEmptyFileContent() {
        assertFalse(fileReverse.createReversedFile("src//test//resources//EmptyFile.txt"));
        System.out.println("empty file content test ran");
    }
    @Test
    public void testUnsupportedFile() {
        assertFalse(fileReverse.createReversedFile("c:\\abc.odt"));
    }
    @Test
    public void testReversedFile() {
        assertTrue(fileReverse.createReversedFile("src//test//resources//ValidFile.txt"));
    }

}

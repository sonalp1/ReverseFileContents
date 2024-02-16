package com.file.operation;

import com.file.operation.FileReverse;

import java.io.IOException;

public class MainClass {
    public static void main(String args[]) throws IOException {

        FileReverse fileReverse=new FileReverse();
        fileReverse.createReversedFile(args[0]);

    }
}

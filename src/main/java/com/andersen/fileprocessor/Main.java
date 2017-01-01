package com.andersen.fileprocessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String inputFile1 = "C:\\TMP\\input1.txt";
        final String inputFile2 = "C:\\TMP\\input2.txt";
        final String outputFile = "C:\\TMP\\output.txt";
        FileMerger merger = new FileMerger();
        merger.mergeFile(inputFile1, inputFile2, outputFile);


    }
}

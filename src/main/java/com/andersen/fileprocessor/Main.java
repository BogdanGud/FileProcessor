package com.andersen.fileprocessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileMerger merger = new FileMerger();
        merger.mergeFile(args);
    }
}

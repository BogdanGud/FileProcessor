package com.andersen.fileprocessor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileMerger {
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    void mergeFile(String[] args) {
        Path pathFile1 = Paths.get(args[0]);
        Path pathFile2 = Paths.get(args[1]);
        Path output = Paths.get(args[2]);
        try (
                BufferedReader reader1 = Files.newBufferedReader(pathFile1, ENCODING);
                BufferedReader reader2 = Files.newBufferedReader(pathFile2, ENCODING);
                BufferedWriter writer = Files.newBufferedWriter(output, ENCODING)) {

            String line;
            String line2;

            do {
                line = reader1.readLine();
                if (line != null) {
                    writer.write(line);
                    writer.newLine();
                }
                line2 = reader2.readLine();
                if (line2 != null) {
                    writer.write(line2);
                    writer.newLine();
                }

            } while ((line != null) || (line2 != null));

        } catch (NoSuchFileException ex) {
            System.out.println("NoSuchFileException caught: " + ex);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException caught: " + e);
        }
    }
}

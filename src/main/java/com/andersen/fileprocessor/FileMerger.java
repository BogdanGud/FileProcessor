package com.andersen.fileprocessor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileMerger {
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private List<String> strings = new ArrayList<>();

    public void mergeFile(String[] args) {
        Path pathFile1 = Paths.get(args[0]);
        Path pathFile2 = Paths.get(args[1]);
        Path output = Paths.get(args[2]);
        try (BufferedReader reader1 = Files.newBufferedReader(pathFile1, ENCODING);
             BufferedReader reader2 = Files.newBufferedReader(pathFile2, ENCODING)) {
            String line = null;
            String line2 = null;
            while ((line = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                strings.add(line);
                strings.add(line2);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(output, ENCODING)) {
            for (String line : strings) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

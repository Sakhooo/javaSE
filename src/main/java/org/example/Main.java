package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
//        Files.createFile()
        File file = Path.of("asd", "asd.txt").toFile();
        try (FileWriter fileWriter = new FileWriter(file, true)){
//            fileWriter.append("")
        }


        System.out.println("Hello world!");
    }
}
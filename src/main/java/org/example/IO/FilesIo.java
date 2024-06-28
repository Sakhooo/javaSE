package org.example.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FilesIo {
    public static void main(String[] args) throws IOException {
//        java.nio.file.Files.createFile()
        File file = Path.of("asd", "asd.txt").toFile();
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.append("");
        }

//        Files.write(file, List.of("Hello"))


    }
}

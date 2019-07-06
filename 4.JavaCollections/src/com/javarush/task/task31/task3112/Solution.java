package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        String remoteFName = url.getFile().split("/")[url.getFile().split("/").length-1];
        Path tmpFile = Files.createTempFile(remoteFName, "");
        Files.copy(url.openStream(), tmpFile, REPLACE_EXISTING);


        return Files.move(tmpFile, downloadDirectory.resolve(remoteFName), REPLACE_EXISTING);
    }
}

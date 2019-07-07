package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String pathString = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path path = Paths.get(pathString);

        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
        }

        List<String> subdirsList = new ArrayList<>();
        List<String> filesList = new ArrayList<>();
        final long[] overallSize = {0L};

        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (Files.isRegularFile(file)) {
                    filesList.add(file.toString());
                    overallSize[0] += Files.size(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                subdirsList.add(dir.toString());
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - " + (subdirsList.size() - 1));
        System.out.println("Всего файлов - " + filesList.size());
        System.out.println("Общий размер - " + overallSize[0]);
    }
}

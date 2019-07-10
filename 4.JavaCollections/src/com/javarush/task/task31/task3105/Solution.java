package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
  public static void main(String[] args) throws IOException {
    File fileToArc = new File(args[0]);
    File zipArc = new File(args[1]);

    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipArc));
    ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipArc));

    List<ZipEntry> arcContents = new ArrayList<>();
    ZipEntry currentEntry;
    do {
      currentEntry = zipIn.getNextEntry();
      if (!currentEntry.isDirectory()){
        arcContents.add(currentEntry);
      }
    } while (null != currentEntry);

    List<String> fileContents = Files.readAllLines(fileToArc.toPath());


    zipIn.close();
    zipOut.close();
  }
}

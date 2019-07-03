package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
  public static void main(String[] args) throws IOException {
    if (args.length == 0)
      return;
    File resultFileAbsolutePath = new File(args[1]);
    if (FileUtils.isExist(resultFileAbsolutePath) && !"allFilesContent.txt".equals(resultFileAbsolutePath.getName())) {
      FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt"));
    }

    List<File> files;
    files = getFileListingNoSort(new File(args[0]));
    Collections.sort(files);

    OutputStream outputStream = new FileOutputStream(resultFileAbsolutePath);
    InputStream inputStream;
    for (File file : files) {
      if (file.isFile()) {
        inputStream = new FileInputStream(file);
        while (inputStream.available() > 0) {
          outputStream.write(inputStream.read());
        }
        new PrintWriter(outputStream).print("\n");
      }
    }

    outputStream.close();
  }

  private static List<File> getFileListingNoSort(File startingDir) {
    List<File> result = new ArrayList<>();
    File[] filesAndDirs = startingDir.listFiles();
    assert filesAndDirs != null;
    for (File file : filesAndDirs) {
      if (file.length() < 50)
        result.add(file);
      if (!file.isFile()) {
        //must be a directory
        //recursive call!
        List<File> deeperList = getFileListingNoSort(file);
        result.addAll(deeperList);
      }
    }
    return result;
  }
}

package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
  private static List<String> getFileTree(String root) {
    List<String> result = new ArrayList<>();
    Queue<File> dirToWalk = new PriorityQueue<>();

    File[] initialFileList = new File(root).listFiles();

    if (null != initialFileList && initialFileList.length > 0) {
      for (File file : initialFileList) {
        if (file.isDirectory())
          dirToWalk.add(file);

        if (file.isFile())
          result.add(file.getAbsolutePath());
      }
    }

    while (!dirToWalk.isEmpty()){
      File[] currentFList = dirToWalk.remove().listFiles();

      if (null != currentFList && currentFList.length > 0) {
        for (File file : currentFList){
          if (file.isDirectory()){
            dirToWalk.add(file);
          }

          if (file.isFile()) {
            result.add(file.getAbsolutePath());
          }
        }
      }
    }


    return result; //new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(root).list())));

  }

  public static void main(String[] args) {
    List<String> fList = getFileTree("D:/d");
    fList.forEach(System.out::println);
  }
}

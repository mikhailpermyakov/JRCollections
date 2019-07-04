package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
  private static List<String> getFileTree(String root) throws IOException {
//    Set<String> result = new HashSet<>();
//    Queue<File> dirToWalk = new PriorityQueue<>();
//    File[] initialFileList = new File(root).listFiles();
//
//    if (null != initialFileList && initialFileList.length > 0) {
//      for (File file : initialFileList) {
//        if (file.isDirectory())
//          dirToWalk.add(file);
//        if (file.isFile())
//          result.add(file.getAbsolutePath());
//      }
//    }
//
//    while (!dirToWalk.isEmpty()){
//      File[] currentFList = dirToWalk.remove().listFiles();
//      if (null != currentFList && currentFList.length > 0) {
//        for (File file : currentFList){
//          if (file.isDirectory())
//            dirToWalk.add(file);
//          if (file.isFile())
//            result.add(file.getAbsolutePath());
//        }
//      }
//    }
//    List<String> list = new ArrayList<>(result);
//    Collections.sort(list);
//    return list; //new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(root).list())));


//    File rootDir = new File(root);
//    List<String> result = new ArrayList<>();
//    Queue<File> fileTree = new PriorityQueue<>();
//
//    Collections.addAll(fileTree, rootDir.listFiles());
//
//    while (!fileTree.isEmpty())
//    {
//      File currentFile = fileTree.remove();
//      if(currentFile.isDirectory()){
//        Collections.addAll(fileTree, currentFile.listFiles());
//      } else {
//        result.add(currentFile.getAbsolutePath());
//      }
//    }

    List<String> list = new ArrayList<>();
    Files.walk(Paths.get(root)).filter(Files::isRegularFile).collect(Collectors.toList()).forEach(i->list.add(i.toString()));
    return list;
  }

  public static void main(String[] args) throws IOException {
    List<String> fList = getFileTree("D:/d");
    fList.forEach(System.out::println);
  }
}

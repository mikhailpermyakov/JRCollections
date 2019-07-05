package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

  private String partOfName;
  private String partOfContent;
  private int minSize = -1;
  private int maxSize = -1;
  private List<Path> foundFiles = new ArrayList<>();

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    byte[] content = Files.readAllBytes(file); // размер файла: content.length
    List<String> contentList = Files.readAllLines(file);
    if ((null != partOfName && file.getFileName().toString().contains(partOfName)) ||
        (null != partOfContent && _contains(contentList, partOfContent)) ||
        (minSize > -1 && content.length > minSize) ||
        (maxSize > -1 && content.length < maxSize))
      foundFiles.add(file);
    return super.visitFile(file, attrs);
  }

  void setPartOfName(String partOfName) {
    this.partOfName = partOfName;
  }

  void setPartOfContent(String partOfContent) {
    this.partOfContent = partOfContent;
  }

  void setMinSize(int minSize) {
    this.minSize = minSize;
  }

  void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  List<Path> getFoundFiles() {
    return foundFiles;
  }

  private boolean _contains(List<String> contentList, String part) {
    for (String content : contentList) {
      if (content.contains(part)) {
        return true;
      }
    }
    return false;
  }
}

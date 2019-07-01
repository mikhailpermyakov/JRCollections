package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.ArrayList;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File folder = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent() + "allFilesContent.txt"));
        }

        ArrayList<String> sortedFileList = new ArrayList<>();
//        folder.isFile();
        for (File file : folder.listFiles()) {
            if (file.length() <= 50) {
                sortedFileList.add(file.getName());
            }

        }
    }
}

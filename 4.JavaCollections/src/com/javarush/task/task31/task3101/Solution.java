package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent() + "allFilesContent.txt"));
        }

        ArrayList<String> sortedFileList = new ArrayList<>();
        Map<String, String> fNames = new HashMap<>();
//        folder.isFile();//todo
        for (File file : folder.listFiles()) {
            if (file.length() <= 50) {
                fNames.put(file.getAbsolutePath(), file.getName());
            }
        }

        sortedFileList = new ArrayList<>(fNames.values());
        sortedFileList.sort(String::compareTo);

        InputStream inputStream;
        OutputStream outputStream = new FileOutputStream(resultFileAbsolutePath);

        for (String fName : sortedFileList) {
            inputStream = new FileInputStream(fName);
            while (true) {
            }
        }
    }
}

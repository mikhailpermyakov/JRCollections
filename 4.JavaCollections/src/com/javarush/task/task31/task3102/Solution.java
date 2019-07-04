package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) {
        return new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(root).list())));

    }

    public static void main(String[] args) {
        List<String> fList = getFileTree("D:/d");
        fList.forEach(System.out::println);
    }
}

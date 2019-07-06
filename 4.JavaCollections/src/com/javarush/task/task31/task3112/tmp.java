package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class tmp {

  public static void main(String[] args) throws IOException {
    URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
    InputStream inputStream = url.openStream();

    Path tempFile = Files.createTempFile("temp-", ".tmp");
    Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

  }
}

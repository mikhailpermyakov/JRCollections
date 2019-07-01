import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Lev01Lec01 {

  public static void main(String[] args) {
//    File originalFile = new File("c:/path/dir2/a.txt");
//    File folder = originalFile.getParentFile();
//
    Arrays.asList(Objects.requireNonNull(new File("d:/1.txt").getParentFile().listFiles())).forEach(System.out::println);

//    for (File file : folder.listFiles()) {
//      System.out.println(file.getName());
//    }
  }
}
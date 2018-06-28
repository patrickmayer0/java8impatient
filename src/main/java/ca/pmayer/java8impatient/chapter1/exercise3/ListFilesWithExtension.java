package ca.pmayer.java8impatient.chapter1.exercise3;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListFilesWithExtension {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] {"src/main/java/ca/pmayer/java8impatient/chapter1"};
        }
        String ext = ".java";
        File f = new File(args[0]);
        List<String> files = Arrays.asList(f.list((dir, fileName) -> {
           return fileName.endsWith(ext); 
        }));
        files.sort((f1, f2) -> f1.compareTo(f2));
        files.forEach(lF -> System.out.println(lF));
    }
}

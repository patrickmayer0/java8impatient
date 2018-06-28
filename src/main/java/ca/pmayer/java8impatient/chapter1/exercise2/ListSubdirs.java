package ca.pmayer.java8impatient.chapter1.exercise2;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListSubdirs {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] {"/"};
        }
        File f = new File(args[0]);
        List<File> subdirs = Arrays.asList(f.listFiles(file -> {
           return file.isDirectory(); 
        }));
        subdirs.forEach(subdir -> System.out.println(subdir.getAbsolutePath()));
    }
}

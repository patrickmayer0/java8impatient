package ca.pmayer.java8impatient.chapter1.exercise4;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListDirsThenFiles {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] {"src/main/java/ca/pmayer/java8impatient/chapter1"};
        }
        List<File> files = Arrays.asList(new File(args[0]).listFiles());
        files.sort((f1, f2) -> { 
            
            // isDir: first criteria (w=10)
            int isDir = Boolean.compare(f2.isDirectory(), f1.isDirectory()) * 10;
                      
            // name: second criteria (w=1)
            int nameCompare = Integer.signum(f1.getAbsolutePath().compareTo(f2.getAbsolutePath()));
            
            return isDir + nameCompare;
        });
        files.forEach(f -> System.out.println(f.isDirectory() + ":" + f.getAbsolutePath()));
    }

}

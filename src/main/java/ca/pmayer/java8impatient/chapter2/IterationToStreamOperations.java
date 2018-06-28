package ca.pmayer.java8impatient.chapter2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class IterationToStreamOperations {

    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        Long count = words.stream().count();
        MessageFormat msg = new MessageFormat("Count: {0}");
        System.out.println(msg.format(new Object[] {count}));
        
        count = words.stream().filter(w -> w.length() > 10).count();
        System.out.println(msg.format(new Object[] {count}));
        
        count = words.parallelStream().filter(w -> w.length() >= 10).count();
        System.out.println(msg.format(new Object[] {count}));
    }

}

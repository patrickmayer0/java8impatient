package ca.pmayer.java8impatient.chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample1 {

    public static void main(String[] args) {
        Comparator<String> comp = (src, trg) -> Integer.compare(src.length(), trg.length());
        
        List<String> toCompare = Arrays.asList("a", "asd", "b", "fghq");
        toCompare.sort(comp);
        
        toCompare.forEach(word -> System.out.println(word));
        
        Collections.shuffle(toCompare);
        
        Collections.sort(toCompare, comp);
        for (String word : toCompare) {
            System.out.println(word);
        }
    }
}

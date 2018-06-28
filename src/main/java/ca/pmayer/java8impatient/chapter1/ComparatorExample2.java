package ca.pmayer.java8impatient.chapter1;

import java.util.Arrays;

public class ComparatorExample2 {
    public static void main(String[] args) {
        String[] toCompare = new String[] {"abc", "3", "454", "", "3145", "0"};
        Arrays.sort(toCompare, (src, trg) -> Integer.compare(src.length(), trg.length()));
        
        Arrays.asList(toCompare).forEach(word -> System.out.println(word));
    }
}

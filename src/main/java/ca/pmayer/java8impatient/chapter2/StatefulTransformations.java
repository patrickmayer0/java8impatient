package ca.pmayer.java8impatient.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StatefulTransformations {

    public static void main(String[] args) throws Exception {
        Stream<String> words = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        words.forEach(w -> System.out.println(w));
        
        System.out.println("Number of words, sorted: " + Arrays.stream(Utils.getWordsArray()).sorted().count());
        System.out.println("Number of words, unique: " + Arrays.stream(Utils.getWordsArray()).distinct().count());
        
        Arrays.stream(Utils.getWordsArray()).distinct().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).forEach(w -> System.out.println(w));
        Arrays.stream(Utils.getWordsArray()).distinct().sorted(Comparator.comparing(String::length).reversed()).forEach(w -> System.out.println(w));
    }
}

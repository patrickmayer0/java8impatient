package ca.pmayer.java8impatient.chapter2;

import java.util.stream.Stream;

public class StatefulTransformations {

    public static void main(String[] args) {
        Stream<String> words = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        words.forEach(w -> System.out.println(w));
        
        
    }
}

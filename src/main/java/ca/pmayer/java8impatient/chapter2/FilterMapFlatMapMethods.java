package ca.pmayer.java8impatient.chapter2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FilterMapFlatMapMethods {

    public static void main(String[] args) throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        
        // filtering on word length >= 10.
        Stream<String> longWords = getWords(contents).filter(w -> w.length() >= 10).peek(w -> System.out.println(w));
        longWords.toArray();
        
        // changing case to upper.
        Stream<String> upperC = getWords(contents).limit(5).map(w -> w.toUpperCase()).peek(w -> System.out.println(w));
        upperC.count();
        
        // changing case to lower.
        Stream<String> lowerC = getWords(contents).limit(5).map(String::toLowerCase).peek(w -> System.out.println(w));
        lowerC.count();
        
        Stream<String> lowerC2 = getWords(contents).limit(3).map(w -> w.toLowerCase(Locale.CANADA_FRENCH)).peek(w -> System.out.println(w));
        lowerC2.count();
        
        Stream<Character> chars = getWords(contents).limit(10).map(w -> w.charAt(0)).peek(w -> System.out.println(w));
        chars.count();
        
        
        // get Stream<Character> then flatten to <Character> 
        Stream<Stream<Character>> carsStreams = getWords(contents).map(w -> Utils.characterStream(w));
        carsStreams.forEach(s -> {
            s.forEach(c -> System.out.print(c));
        });
        System.out.println();
        getWords(contents).flatMap(w -> Utils.characterStream(w)).forEach(c -> System.out.print(c));
    }

    private static Stream<String> getWords(String contents) {
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
        return words;
    }

}

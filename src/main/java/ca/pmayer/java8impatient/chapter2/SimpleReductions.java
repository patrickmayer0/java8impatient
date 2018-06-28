package ca.pmayer.java8impatient.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleReductions {

    public static void main(String[] args) throws Exception {
        Optional<String> largest = Arrays.stream(Utils.getWordsArray()).max(String::compareToIgnoreCase);
        System.out.println(largest.isPresent() ? largest.get() : "None");
        
        largest = Arrays.stream(Utils.getWordsArray()).filter(w -> {return w.startsWith("w") || w.startsWith("W");}).findFirst();
        System.out.println(largest.isPresent() ? largest.get() : "None");
        
        List<String> wordsList = Arrays.asList(Utils.getWordsArray());
        largest = wordsList.parallelStream().filter(w -> {return w.startsWith("q") || w.startsWith("Q");}).findAny();
        System.out.println(largest.isPresent() ? largest.get() : "None");
        
    }

}

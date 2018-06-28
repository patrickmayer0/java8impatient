package ca.pmayer.java8impatient.chapter1;

import java.util.Arrays;

public class MethodReferencesExample1 {

    public static void main(String[] args) {
        String[] words = new String[] { "0", "", "12", "a", "Z", "234" };
        Arrays.sort(words, String::compareToIgnoreCase);
        
        Arrays.asList(words).forEach(w -> System.out.println(w));
    }
}

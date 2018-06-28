package ca.pmayer.java8impatient.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class Utils {

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }

}

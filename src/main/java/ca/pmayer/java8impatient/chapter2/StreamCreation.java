package ca.pmayer.java8impatient.chapter2;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) throws Exception {
        MessageFormat msg = new MessageFormat("Count: {0}");
        Long count = 0L;
        // from a List
        String[] splitWords = Utils.getWordsArray();
        List<String> wordsList = Arrays.asList(splitWords);
        Stream<String> words = wordsList.stream();
        count = words.count();
        output(msg, count);

        // from an array:
        words = Stream.of(splitWords);
        count = words.count();
        output(msg, count);

        // from a single element
        words = Stream.of("Hello");
        count = words.count();
        output(msg, count);

        // empty
        words = Stream.empty();
        count = words.count();
        output(msg, count);

        // generate values indefinitely... or until limit is reached (10 in this case).
        words = Stream.generate(() -> {
            int length = (int) Math.ceil(Math.random() * 12.0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= length; i++) {
                int c = (int) Math.floor(Math.random() * 26) + 65;
                sb.append((char) c);
            }
            System.out.println(sb.toString());
            return sb.toString();
        });
        count = words.limit(10).count();
        output(msg, count);
        
        // generate value indefinitely, based on previous value (limit to 10 in this case)
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, v -> v.multiply(BigInteger.valueOf(2))).limit(11);
        integers.forEach(v -> System.out.println(v));
        
        // generate random numbers (limit to 10 in this case)
        Stream<Double> random = Stream.generate(Math::random).limit(10);
        random.forEach(v -> System.out.println(v));
    }



    private static void output(MessageFormat msg, Long count) {
        System.out.println(msg.format(new Object[] { count }));
    }

}

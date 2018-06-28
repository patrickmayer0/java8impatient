package ca.pmayer.java8impatient.chapter2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class ExtractingSubstreamsCombiningStreams {

    public static void main(String[] args) {
        // generate 100 random numbers then stop generation.
        AtomicInteger count = new AtomicInteger(0);
        Stream.generate(Math::random).limit(100).forEach(r -> {
            int current = count.incrementAndGet();
            System.out.println(current + ": " + r);
        });
        
        count.set(0);
        
        // generate 100 random numbers but skip first 90 numbers.
        Stream.generate(Math::random).limit(100).peek(r -> {
            if (count.get() < 90) {
                count.incrementAndGet();
            }
        }).skip(90).forEach(r -> {
            int current = count.incrementAndGet();
            System.out.println(current + ": " + r);
        });
        
        Stream<Character> combined = Stream.concat(Utils.characterStream("Hello"), Utils.characterStream("World"));
        combined.forEach(c -> System.out.print(c));
        System.out.println();
        
        combined = Stream.concat(Utils.characterStream("Hello1234567890").limit(5), Utils.characterStream("World1234567890").skip(5));
        combined.forEach(c -> System.out.print(c));
        System.out.println();
        
        Integer[] powers = Stream.iterate(1, p -> p * 2).peek(i -> System.out.println("Getting: " + i)).limit(10).toArray(i -> new Integer[i]);
        Arrays.stream(powers).forEach(i -> System.out.println("Got: " + i));
        
        
    }

}

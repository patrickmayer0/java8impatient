package ca.pmayer.java8impatient.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalValue {

    public static void main(String[] args) {
        Optional<Boolean> optionalValue = Optional.empty();
        optionalValue.ifPresent(v -> System.out.println(v));
        
        optionalValue = Optional.of(Boolean.TRUE);
        optionalValue.ifPresent(v -> System.out.println(v));
        
        List<Integer> results = new ArrayList<>();
        Optional<Integer> optInt = Optional.of(15);
        optInt.ifPresent(i -> results.add(i));
        
        optInt.map(i -> results.add(i));
        System.out.println(results.size());
        
        optInt.map(results::add);
        System.out.println(results.size());
        
        System.out.println(optInt.orElse(1));
        optInt = Optional.empty();
        System.out.println(optInt.orElse(2));
        
        Optional<String> optDir = Optional.empty();
        System.out.println(optDir.orElseGet(() -> System.getProperty("user.dir")));
        optDir = Optional.of("/abc/");
        System.out.println(optDir.orElseGet(() -> System.getProperty("user.dir")));
        
        
        // pipeline examples
        Optional<Double> result = inverse(0.25).flatMap(v -> squareRoot(v));
        System.out.println(result.orElse(Double.NaN));
        
        // stops pipeline at first step.
        result = inverse(0.0).flatMap(v -> squareRoot(v));
        System.out.println(result.orElse(Double.NaN));
        
        // stops pipeline at second step.
        result = inverse(-0.25).flatMap(v -> squareRoot(v));
        System.out.println(result.orElse(Double.NaN));
        
        // pipeline examples
        result = inverse(0.25).flatMap(OptionalValue::squareRoot);
        System.out.println(result.orElse(Double.NaN));
    }
    
    public static Optional<Double> inverse(Double x) {
        return x != 0 ? Optional.of(1/x) : Optional.empty();
    }
    public static Optional<Double> squareRoot(Double x) {
        return x > 0 ? Optional.of(Math.sqrt(x)) : Optional.empty();
    }
}

package ca.pmayer.java8impatient.chapter1.exercise9;

public class TestCollection2 {

    public static void main(String[] args) {
        Collection2<Integer> l = new ArrayList2<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }

        l.forEachIf(System.out::println, n -> {
            return n % 3 == 0;
        });
    }

}

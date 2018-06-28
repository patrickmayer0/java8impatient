package ca.pmayer.java8impatient.chapter1.exercise9;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<E> extends Collection<E> {

    default void forEachIf(Consumer<E> action, Predicate<E> filter) {
        
        forEach(e -> {
            if (filter.test(e)) {
                action.accept(e);
            }
        });
    }
}

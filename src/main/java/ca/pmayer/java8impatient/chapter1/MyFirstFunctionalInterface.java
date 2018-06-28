package ca.pmayer.java8impatient.chapter1;

@FunctionalInterface
public interface MyFirstFunctionalInterface<T, U> {

    int doWork(T t, U u);
}

package ca.pmayer.java8impatient.chapter1.interfaces;

public interface I2 {

    default String doWork() {
        return this.getClass().getName();
    };
}

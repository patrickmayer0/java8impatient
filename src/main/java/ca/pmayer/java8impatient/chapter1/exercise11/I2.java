package ca.pmayer.java8impatient.chapter1.exercise11;

public interface I2 {

    void doWork();
    
    void f();
    
    static void g() {
        System.out.println(I2.class.getName());
    }
}

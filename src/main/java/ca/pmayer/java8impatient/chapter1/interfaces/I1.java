package ca.pmayer.java8impatient.chapter1.interfaces;

public interface I1 {

    String doWork();
    
    static String myWork() {
        return I1.class.getName();
    };
}

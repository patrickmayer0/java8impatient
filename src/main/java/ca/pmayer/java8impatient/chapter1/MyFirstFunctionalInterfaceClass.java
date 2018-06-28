package ca.pmayer.java8impatient.chapter1;

public class MyFirstFunctionalInterfaceClass {

    public static void main(String[] args) {
        MyFirstFunctionalInterface<String, Long> mffi = (str, val) -> {
            System.out.println(str + " " + val);
            return val.intValue();
        };
        
        System.out.println(mffi.doWork("Allo", 2L));
    }

}

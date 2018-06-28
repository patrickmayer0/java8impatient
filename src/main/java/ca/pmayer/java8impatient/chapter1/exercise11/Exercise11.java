package ca.pmayer.java8impatient.chapter1.exercise11;

public class Exercise11 implements I1, I2 {

    @Override
    public void doWork() {
        // TODO Auto-generated method stub

    }
    
    public void f() {
        I1.super.f();
    }
    
    public void g() {
        I1.g();
    }

    //private String g = "g";
    
}

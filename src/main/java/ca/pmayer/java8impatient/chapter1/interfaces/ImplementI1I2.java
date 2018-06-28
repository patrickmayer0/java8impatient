package ca.pmayer.java8impatient.chapter1.interfaces;

public class ImplementI1I2 implements I1, I2 {

    public String doWork() {
        return I2.super.doWork();
    }

    public static void main(String[] args) {
        ImplementI1I2 o = new ImplementI1I2();
        System.out.println(o.doWork());
        
        System.out.println(I1.myWork());
        
        
    }
}

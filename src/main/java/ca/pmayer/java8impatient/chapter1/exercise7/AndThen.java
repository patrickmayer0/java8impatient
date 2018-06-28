package ca.pmayer.java8impatient.chapter1.exercise7;

public class AndThen {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(andThen(() -> {
            System.out.println("Run 1");
        }, () -> {
            System.out.println("Run 2");
        }));
        t.start();
    }

}

package ca.pmayer.java8impatient.chapter1.exercise6;

public class UncheckMethod {

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {

        Thread t = new Thread(uncheck(() -> {
            System.out.println("Zzzz...");
            Thread.sleep(10000);
        }));
        
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        t.interrupt();
    }
}

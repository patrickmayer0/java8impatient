package ca.pmayer.java8impatient.chapter1;

import java.util.concurrent.Callable;

public class CatchingCheckedExceptions {

    public static void main(String[] args) {
        Runnable sleeper = () -> {
            System.out.println("Zzzzz....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // pas beau: il vaut mieux utiliser une autre interface.
                e.printStackTrace();
            }
        };

        Callable<Void> betterSleeper = () -> {
            System.out.println("Zzzzz....");
            
            // mieux: Callable accepte les Checked Exceptions.
            Thread.sleep(1000);
            return null;
        };
    }

}

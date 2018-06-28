package ca.pmayer.java8impatient.chapter1.exercise8;

import java.util.ArrayList;
import java.util.List;

public class CaptureOnForLoop {

    public static void main(String[] args) {
        String[] names = new String[] {"1", "2", "3", "4", "5"};
        List<Runnable> runners = new ArrayList<>(); 
        for (String n : names) {
            runners.add(() -> System.out.println(n));
        }
        runners.forEach(r -> {
            new Thread(r).start();
        });
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        
        runners.clear();
        for (int i = 0; i < names.length; i++) {
            // does not work: i is not final
            //runners.add(() -> System.out.println(names[i]));
            
            // works: lI is effectively final (non-mutable)
            Integer lI = Integer.valueOf(i);
            runners.add(() -> System.out.println(names[lI]));
        }
    }

}

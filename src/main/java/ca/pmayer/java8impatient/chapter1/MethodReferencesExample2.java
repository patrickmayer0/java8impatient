package ca.pmayer.java8impatient.chapter1;

public class MethodReferencesExample2 {

    static class Greeter {
        public void greet() {
            System.out.println("Hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
    static class ConcurrentGreeter extends Greeter {
        public void greet( ) {
            Thread t = new Thread(super::greet);
            t.start();
            System.out.println("Waiting...");
            try {
                t.join();
            } catch (InterruptedException e) {
            }
            System.out.println("Done!");
        }
    }
    public static void main(String[] args) {
        ConcurrentGreeter cg = new ConcurrentGreeter();
        cg.greet();
    }
}

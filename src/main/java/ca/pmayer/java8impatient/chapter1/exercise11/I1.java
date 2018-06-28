package ca.pmayer.java8impatient.chapter1.exercise11;

public interface I1 {

    void doWork();
    
    default void f() {
        System.out.println(this.getClass().getName());
    };
    
    static final String g = "g";
    
    public String h = "h";
    
    static void g() {
        System.out.println(I1.class.getName());
        System.out.println(g);
    }
}

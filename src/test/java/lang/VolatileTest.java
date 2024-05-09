package lang;

public class VolatileTest {

    private volatile static int i = 1;

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            i = 2;
            System.out.println("Thread2 " + i);
        });
        Thread t1 = new Thread(() -> {
            Thread.yield();
            System.out.println("Thread1 " + i);
        });
        t2.start();
        t1.start();
    }
}

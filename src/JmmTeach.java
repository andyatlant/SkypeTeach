/**
 * Created by antsi on 16.01.2016.
 */
public class JmmTeach {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());

        System.out.println(t1.getStackTrace());
        t1.start();
        t1.join();
        Thread t2 =new Thread(new T2());
        t2.start();
        System.out.println(t2.getPriority());
    }
}

class T1 implements Runnable {
    public static long x;
    public static volatile long y;

    @Override
    public void run() {
        x = 5;
        y = 10;

    }
}

class T2 implements Runnable {

    @Override
    public void run() {
        while (T1.y == 0) {

        }
        System.out.println(T1.x);
        System.out.println(T1.y);
    }
}

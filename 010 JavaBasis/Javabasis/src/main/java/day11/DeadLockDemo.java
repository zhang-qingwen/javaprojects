package day11;

class Ticket implements Runnable {
    private int tick = 100;
    Object obj = new Object();
    boolean flag = true;

    public synchronized void show() {
        if (tick > 0) {

        }
    }

    public void run() {
        if (flag) {
            while (true) {
                synchronized (obj) {
                    if (tick > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            System.out.println(Thread.currentThread().getName() + "...code : " + tick--);
                        }
                    } else {
                        while (true)
                            show();
                    }
                }
            }
        }
    }
}

public class DeadLockDemo {

}

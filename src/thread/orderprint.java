package thread;

import java.util.concurrent.Semaphore;

public class orderprint {
        private static int count = 0;
        static Semaphore a = new Semaphore(1);

    public static void main(String[] args) {
        PrintOrder or = new PrintOrder();
        Thread t1 = new Thread(or);
        Thread t2 = new Thread(or);
        t1.start();
        t2.start();
    }

       static class PrintOrder implements Runnable{
            public void run(){
                try {
                    a.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(count<=100){
                        System.out.println(Thread.currentThread().getName()+count++);
                    }
                a.release();

            }
        }


}

package qwe;

public class lock1 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {
        boolean flag = true;
        deadlock A = new deadlock(lock1,lock2,flag);
        deadlock B = new deadlock(lock1,lock2,!flag);
        Thread t1 = new Thread(A);
        Thread t2 = new Thread(B);
        t1.start();
        t2.start();

    }

    static class deadlock implements Runnable{
            Object lock1;
            Object lock2;
            boolean flag;
            private deadlock(Object lock1,Object lock2,boolean flag){
                this.lock1 = lock1;
                this.lock2 = lock2;
                this.flag = flag;
            }
        @Override
        public void run() {
            if(flag){
                synchronized (lock1){
                    System.out.println("find lock2");
                    synchronized (lock2){
                        System.out.println("find success");
                    }
                }
            }
            if(!flag){
                synchronized (lock2){
                    System.out.println("find lock1");
                    synchronized (lock1){
                        System.out.println("find success");
                    }
                }
            }
        }
    }


}

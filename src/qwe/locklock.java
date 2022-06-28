package qwe;

public class locklock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        deadlock dead = new deadlock(lock1,lock2,true);
        deadlock dead2 = new deadlock(lock1,lock2,false);
        Thread t1 = new Thread(dead);
        Thread t2 = new Thread(dead2);
        t1.start();
        t2.start();
    }

    static class deadlock implements Runnable{
        private boolean flag;
        private Object lock1;
        private Object lock2;
        public deadlock(Object lock1,Object lock2,boolean flag){
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.flag = flag;
        }
        @Override
        public void run() {
            if(flag){
                    synchronized (lock1){
                        System.out.println("获取lock2");
                        synchronized (lock2){
                            System.out.println("获取成功");
                        }
                    }
            }
            if(!flag){
                synchronized (lock2){
                    System.out.println("获取lock1");
                    synchronized (lock1){
                        System.out.println("获取成功");
                    }
                }
            }
        }
    }

}

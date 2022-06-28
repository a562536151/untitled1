package thread;

class WaitNotifyPrint {

    private static int count = 0;
    //两个线程竞争该对象锁
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TurningRunner run = new TurningRunner();
        Thread thread2 = new Thread(run,"Odd");
        Thread thread = new Thread(run,"even");
                thread.start();
                thread2.start();
/*        new Thread(new TurningRunner(), "偶数").start();
        new Thread(new TurningRunner(), "奇数").start();*/
    }

    //1. 拿到锁直接就打印。
    //2. 打印完，唤醒其他线程，自己就休眠。
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
            while (count <= 100) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    //打印完，唤醒其他线程
                    lock.notify();
                    //如果任务还没结束，就调用wait()让出当前的锁
                        try {
                            //自己休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                }
            }
        }
    }
}
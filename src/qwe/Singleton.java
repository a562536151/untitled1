package qwe;
import lombok.Synchronized;

public class Singleton {
    private Singleton(){};
    private static volatile Singleton singleton;   //避免没有被实例化的对象提前指向它的地址空间
    public static Singleton getInstance(){
        if(singleton==null){            //保证没有被实例化的对象才能拿锁
            synchronized (Singleton.class){
                if(singleton==null){            //当多个线程执行完判空操作，此时一个线程进去实例化以后，避免第二个完成判空操作的线程也去实例化
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}


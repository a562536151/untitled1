package qwe;


//静态内部类方式实现单例巧妙地利用了 Java 类加载机制，
// 保证其在多线程环境下的线程安全性。当一个类被加载时，其静态内部类是不会被同时加载的，
// 只有第一次被调用时才会初始化，而且我们不能通过反射的方式获取内部的属性。
// 由此可见，静态内部类方式实现单例更加安全，可以防止被反射入侵。
public class Singleton2 {
    private Singleton2(){}
    private static class Singleton{
        static Singleton2 singleton2 = new Singleton2();
    }
    public static Singleton2 getInstance(){  //在主函数开始时调用，返回一个实例化对象.此对象是static的，在内存中保留着它的引用
        return Singleton.singleton2;
    }

}

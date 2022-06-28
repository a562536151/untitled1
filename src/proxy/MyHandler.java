package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    Mapper map;
    public MyHandler(Mapper map){
        this.map = map;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Mapper mapper = (Mapper) method.invoke(map);
        System.out.println("after");

        return null;
    }
}

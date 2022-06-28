import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Mapper {
    public void write();
}

class Mapperiml implements Mapper{

    @Override
    public void write() {
        System.out.println("hello");
    }
}

class MyHandler implements InvocationHandler{
        Mapper map;
        public MyHandler(Mapper map){
            this.map = map;
        }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Mapper map2 = (Mapper)method.invoke(map);
        System.out.println("after");
        return null;
    }

    public static void main(String[] args) {
        Mapper a = new Mapperiml();
        MyHandler hand = new MyHandler(a);
        Mapper b = (Mapper) Proxy.newProxyInstance(a.getClass().getClassLoader(),new Class[]{Mapper.class},hand);
        b.write();
    }
}
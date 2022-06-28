package proxy;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        Mapper mapperA = new Mapperiml();
        MyHandler hand = new MyHandler(mapperA);
        Mapper MapperB = (Mapper)Proxy.newProxyInstance(hand.getClass().getClassLoader(),new Class[]{Mapper.class},hand);
        MapperB.insert();
    }
}

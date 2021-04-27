package com.ifreedomer.dynamicproxy;

import com.ifreedomer.dynamicproxy.ticket.Heyan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //用反射来new一个无参构造Heyan
        noParamterConstruct();
        hasParameterConstruct();
    }

    private static void hasParameterConstruct() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Heyan> heyanClass = Heyan.class;
        Constructor<Heyan> constructor = heyanClass.getConstructor(int.class);
        Heyan heyan = constructor.newInstance(10);
        heyan.buyFlyTicket();
    }

    private static void noParamterConstruct() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Heyan> heyanClass = Heyan.class;
        //第二种：通过对象实例方法获取对象
        //Class cla = foo.class;
        //
        //第三种：通过Class.forName方式
        //Class cla = Class.forName("xx.xx.Foo");
        Constructor<Heyan> constructor = heyanClass.getConstructor();
        Heyan heyan = constructor.newInstance();
        heyan.buyFlyTicket();
    }
}

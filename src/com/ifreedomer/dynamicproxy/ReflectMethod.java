package com.ifreedomer.dynamicproxy;

import com.ifreedomer.dynamicproxy.ticket.Heyan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {

    public static void staticMethod(){
        System.out.println("staticMethod");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        callStaticMethod();
    }

    private static void callStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ReflectMethod> reflectMethodClass = ReflectMethod.class;
        Method staticMethod = reflectMethodClass.getMethod("staticMethod");
        staticMethod.invoke(null);
    }

    private static void callMemeberMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Heyan> heyanClass = Heyan.class;
        Constructor<Heyan> constructor = heyanClass.getConstructor();
        Heyan heyan = constructor.newInstance();
        //获取方法对象
        Method buyFlyTicket = heyan.getClass().getMethod("buyFlyTicket");
        //使用heyan这个对象来执行
        buyFlyTicket.invoke(heyan);
    }
}

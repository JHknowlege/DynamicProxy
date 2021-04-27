package com.ifreedomer.dynamicproxy.ticket;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicTickProxy implements InvocationHandler {
    Object target;
    public DynamicTickProxy(Object proxyObject) {
        this.target = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        System.out.println("帮你抢票");
        Object invoke = method.invoke(target, objects);
        System.out.println("把票给你");
        return invoke;
    }

    public static void main(String[] args) {
        //保存Proxy字节码文件到硬盘
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Heyan heyan = new Heyan(19);
        TicketBoy ticketBoyProxy = (TicketBoy) Proxy.newProxyInstance(heyan.getClass().getClassLoader(), heyan.getClass().getInterfaces(), new DynamicTickProxy(heyan));
        ticketBoyProxy.buyFlyTicket();
        ticketBoyProxy.buyTrainTicket();
    }
}

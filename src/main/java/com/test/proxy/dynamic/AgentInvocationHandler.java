package com.test.proxy.dynamic;

import com.test.proxy.statics.Renter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-5-6
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class AgentInvocationHandler implements InvocationHandler {
    private Renter renter;
    public AgentInvocationHandler(Renter renter) {
       this.renter = renter;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String proxyName = proxy.getClass().getSimpleName();
        System.out.println("我是代理: " + proxyName);
        System.out.println(proxyName + "找到一个房源");//中介做的事情
        System.out.println(proxyName + "联系到了房东");//中介做的事情
        method.invoke(renter, args);
        System.out.println(proxyName + "收到" + renter.getName() + "的中介费");//中介做的事情
        return null;
    }
}

package com.test.proxy.dynamic;

import com.test.proxy.statics.HouseRenter;
import com.test.proxy.statics.Renter;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-5-6
 * Time: 下午10:27
 * To change this template use File | Settings | File Templates.
 */
public class DynamicAgent {
    public static Renter createAgent(HouseRenter renter) {
        return (Renter)Proxy.newProxyInstance(renter.getClass().getClassLoader(), new Class<?>[]{Renter.class}, new AgentInvocationHandler(renter));
    }
}

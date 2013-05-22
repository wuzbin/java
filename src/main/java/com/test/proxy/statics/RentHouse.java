package com.test.proxy.statics;

import com.test.proxy.dynamic.DynamicAgent;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-27
 * Time: 下午11:18
 * To change this template use File | Settings | File Templates.
 */
public class RentHouse {
    public static void main(String[] args) {
        HouseRenter lilei = new HouseRenter("李蕾");
        Renter agent = DynamicAgent.createAgent(lilei);
        agent.rent();
    }
}

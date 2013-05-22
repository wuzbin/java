package com.test.proxy.statics;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-27
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
public class HouseRenter implements Renter {
    private String name;
    public HouseRenter(String name) {
        this.name = name;
    }
    @Override
    public void rent() {
        System.out.println(name + "与房东商量价钱");
        //假设价钱总是能商量好
        System.out.println(name + "与房东签约");
    }

    @Override
    public String getName() {
        return name;
    }
}

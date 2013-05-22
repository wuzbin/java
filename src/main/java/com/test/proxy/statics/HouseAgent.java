package com.test.proxy.statics;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-27
 * Time: 下午10:55
 * To change this template use File | Settings | File Templates.
 */
public class HouseAgent implements Renter{
    private Renter customer;
    private String name;
    public HouseAgent(Renter renter) {
        name = "小李";  //为了简单起见写死，中介都叫小李
        this.customer = renter;
    }

    @Override
    public void rent() {//中介就好像跟要租房的人一样
        System.out.println(name + "找到一个房源");//中介做的事情
        System.out.println(name + "联系到了房东");//中介做的事情
        customer.rent();//最终还是由房客真正做租的动作
        System.out.println(name + "收到" + customer.getName() + "的中介费");//中介做的事情
    }

    @Override
    public String getName() {
        return name;
    }
}

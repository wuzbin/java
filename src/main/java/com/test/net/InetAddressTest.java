package com.test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-3
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println("-------------------------------------");
            InetAddress inetAddress1 = InetAddress.getLocalHost();
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1.getCanonicalHostName());
            System.out.println("-------------------------------------");
            InetAddress[] inetAddresses = InetAddress.getAllByName("localhost");
            System.out.println(inetAddresses.length);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

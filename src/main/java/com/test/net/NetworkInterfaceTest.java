package com.test.net;

import java.net.*;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-2
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class NetworkInterfaceTest {
    public static void main(String[] args) throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                System.out.println("----------------------------------------");
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println(networkInterface.getDisplayName());
                System.out.println(networkInterface.getName());
                System.out.println(networkInterface.getSubInterfaces().hasMoreElements());
                System.out.println("****************************************");
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
            System.out.println(networkInterface.getDisplayName());
            System.out.println(networkInterface.getHardwareAddress());
            List<InterfaceAddress> addressList = networkInterface.getInterfaceAddresses();
            for (InterfaceAddress address : addressList) {
                System.out.println("---------------------------------------");
                System.out.println(address.getAddress());
                System.out.println("***************************************");
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            NetworkInterface networkInterface1 = NetworkInterface.getByInetAddress(InetAddress.getByName("10.1.156.73"));
            System.out.println(networkInterface1.getDisplayName());
            System.out.println(networkInterface1.getHardwareAddress());
            List<InterfaceAddress> addressList1 = networkInterface.getInterfaceAddresses();
            for (InterfaceAddress address : addressList1) {
                System.out.println("---------------------------------------");
                System.out.println(address.getAddress());
                System.out.println("***************************************");
            }

        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

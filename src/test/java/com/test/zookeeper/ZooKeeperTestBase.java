package com.test.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-20
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
public class ZooKeeperTestBase {
    protected static ZooKeeper zooKeeper;
    protected static Watcher watcher;

    @BeforeClass
    public static void startUp(){
        System.out.println("-------------------start up-----------------");
        zooKeeper = ZooKeeperTest.getZooKeeper();
        watcher = ZooKeeperTest.watcher;
    }

    @AfterClass
    public static void clear() {
        System.out.println("-------------------clear--------------------");
        try {
            zooKeeper.delete("/wuzbin",-1);
        } catch (InterruptedException e) {
            log("-----clear---------InterruptedException----");
        } catch (KeeperException e) {
            log("-----clear---------KeeperException----");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    protected static void log(String msg) {
        System.out.println(msg);
    }
}

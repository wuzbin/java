package com.test.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-18
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class ZooKeeperTest {
    public static Watcher watcher = new MyWatcher();
    public static ZooKeeper getZooKeeper() {
        try {
            ZooKeeper zooKeeper =  new ZooKeeper("zookeeper.quorum97:3181,zookeeper.quorum98:3181,zookeeper.quorum99:3181", 60000, watcher);
            return zooKeeper;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ZooKeeper zooKeeper =  getZooKeeper();
        try {
            String name  = zooKeeper.create("/wuzbin", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println(name);
            zooKeeper.exists("/wuzbin", watcher);
        } catch (KeeperException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}

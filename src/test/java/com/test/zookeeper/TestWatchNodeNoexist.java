package com.test.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-20
 * Time: 下午9:38
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class TestWatchNodeNoexist extends ZooKeeperTestBase {

    @Test
    public void testWatchNodeNonexist(){
        try {
            byte [] data = {1};
            zooKeeper.create("/wuzbin", data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            log("testWatchNodeNonexist----zooKeeper.create----KeeperException");
        } catch (InterruptedException e) {
            log("testWatchNodeNonexist----zooKeeper.create----InterruptedException");
        }
        Stat stat = new Stat();
        try {
            zooKeeper.getData("/wuzbin", watcher, stat);
        } catch (KeeperException e) {
            log("----testWatchNodeNonexist--getData---KeeperException-------");
        } catch (InterruptedException e) {
            log("-----testWatchNodeNonexist--getData----InterruptedException---");
        }
        try {
            zooKeeper.exists("/wuzbin", watcher);
        } catch (KeeperException e) {
            log("----testWatchNodeNonexist--exists---KeeperException-------");
        } catch (InterruptedException e) {
            log("----testWatchNodeNonexist--exists---InterruptedException-------");
        }
        byte[] data1 = {2};
        try {
            zooKeeper.setData("/wuzbin", data1, stat.getVersion());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}

package com.test.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-18
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class MyWatcher implements Watcher{
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.getType());
        System.out.println(watchedEvent.getState());
    }
}

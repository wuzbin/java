package com.test.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-5-13
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class MutilObject {
    private static Map<String, Lock> locks = new ConcurrentHashMap<String, Lock>();

    public static void main(String[] args) {
        locks.put("1", new ReentrantLock());
        locks.put("2", new ReentrantLock());
        new Thread(new Runnable() {
            @Override
            public void run() {
                logical("1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                logical("1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                logical("2");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                logical("2");
            }
        }).start();
    }

    public static void logical(String id) {
        Lock lock = locks.get(id);
        synchronized (lock) {
            System.out.println(id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

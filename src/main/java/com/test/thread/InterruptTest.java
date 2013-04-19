package com.test.thread;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-18
 * Time: 下午5:21
 * To change this template use File | Settings | File Templates.
 */
public class InterruptTest {
    public static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++<20) {
                System.out.println("t1-" + t4.getState() + "----" + t4.isInterrupted());
                Thread.yield();
            }
        }
    });
    public static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++<20) {
                System.out.println("t2-"  + t4.getState() + "----" + t4.isInterrupted());
                Thread.yield();
            }
        }
    });
    public static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++<20) {
                System.out.println("t3-"  + t4.getState() + "----" + t4.isInterrupted());
                Thread.yield();
            }
        }
    });
    public static Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++<20) {
                System.out.println("t4-"  + t4.getState() + "----" + t4.isInterrupted());
                Thread.yield();
            }
        }
    });

    public static void main(String[] args) {
        t2.start();
        t1.start();
        t3.start();
        t4.start();
    }
}

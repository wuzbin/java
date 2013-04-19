package com.test.thread;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-15
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class JoinTest {
    private static class MyRunable implements Runnable {
        @Override
        public void run() {
            int i = 1;
            while (i++<50) {
                System.out.println("my runable");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("my runable interrupted");
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new MyRunable());
        t.start();
        t.join();
        System.out.println(t.isInterrupted());
        System.out.println("end");
    }
}

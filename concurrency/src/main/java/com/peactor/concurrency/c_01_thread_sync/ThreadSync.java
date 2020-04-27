package com.peactor.concurrency.c_01_thread_sync;

/**
 * @Description: 测试同步方法与非同步方法
 * @Author: Ifan
 * date: 2020-04-22
 **/
public class ThreadSync {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end...");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2");
    }

    public static void main(String[] args) {
        ThreadSync threadSync = new ThreadSync();
        new Thread(threadSync::m1, "t1").start();
        new Thread(threadSync::m2, "t2").start();
    }
}

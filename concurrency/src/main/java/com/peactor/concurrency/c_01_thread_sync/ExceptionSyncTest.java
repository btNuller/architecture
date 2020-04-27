package com.peactor.concurrency.c_01_thread_sync;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试线程执行同步
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class ExceptionSyncTest {

    private int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while(true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count: " + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 5) {
                int i = 1 / 0;//此处抛出异常,锁将被释放
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        ExceptionSyncTest exceptionSyncTest = new ExceptionSyncTest();
        Runnable r = new Runnable() {
            public void run() {
                exceptionSyncTest.m();
            }
        };
        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();
    }

}

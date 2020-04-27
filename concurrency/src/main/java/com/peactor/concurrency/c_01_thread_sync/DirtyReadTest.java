package com.peactor.concurrency.c_01_thread_sync;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试脏读
 * @Author: Ifan
 * date: 2020-04-22
 **/
public class DirtyReadTest {

    private String name;

    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        DirtyReadTest dirtyReadTest = new DirtyReadTest();
        new Thread(()->dirtyReadTest.set("test", 100.31)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dirtyReadTest.getBalance());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dirtyReadTest.getBalance());
    }
}

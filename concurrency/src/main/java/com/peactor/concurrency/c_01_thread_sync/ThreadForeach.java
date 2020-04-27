package com.peactor.concurrency.c_01_thread_sync;

/**
 *
 * @Author: Ifan
 * date: 2020-04-22
 **/
public class ThreadForeach implements Runnable {

    private int count = 100;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        ThreadForeach threadForeach = new ThreadForeach();
        for(int i = 0; i < 100; i++) {
            new Thread(threadForeach, "THREAD" + i).start();
        }
    }
}

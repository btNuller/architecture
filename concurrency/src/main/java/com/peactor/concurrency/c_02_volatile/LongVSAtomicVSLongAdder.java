package com.peactor.concurrency.c_02_volatile;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: 多线程并发场景测试long AtomicLong LongAdder
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class LongVSAtomicVSLongAdder {

    static long count2 = 0L;

    static AtomicLong count1 = new AtomicLong(0L);

    static LongAdder count3  = new LongAdder();

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[1000];
        sync(threads);
        longadder(threads);
        atomic(threads);
    }

    private static void longadder(Thread[] threads) throws InterruptedException {
        for(int i =0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int k = 0; k < 100000; k++) {
                    count3.increment();
                }
            });
        }

        long startLongAdder = System.currentTimeMillis();
        for (Thread th : threads) th.start();
        for (Thread th : threads) th.join();
        long endLongAdder = System.currentTimeMillis();
        System.out.println("longAdder : " + count2 + " time : " + (endLongAdder - startLongAdder));
    }

    private static void atomic(Thread[] threads) throws InterruptedException {
        for(int i =0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int k = 0; k < 100000; k++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread th : threads) th.start();
        for (Thread th : threads) th.join();
        long end = System.currentTimeMillis();

        //TimeUnit.SECOND.sleep(10);
        System.out.println("Atomic : " + count1.get() + " time " + (end - start));
    }

    private static void sync(Thread[] threads) throws InterruptedException {
        Object lock = new Object();
        for(int i =0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int k = 0; k < 100000; k++) {
                    synchronized (lock) {
                        count2++;
                    }
                }
            });
        }
        long startSync = System.currentTimeMillis();
        for (Thread th : threads) th.start();
        for (Thread th : threads) th.join();
        long endSync = System.currentTimeMillis();
        System.out.println("Sync : " + count2 + " time : " + (endSync - startSync));
    }
}

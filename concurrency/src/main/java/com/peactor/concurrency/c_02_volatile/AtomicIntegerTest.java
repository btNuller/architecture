package com.peactor.concurrency.c_02_volatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 测试atomicInteger
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class AtomicIntegerTest {

    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for(int i = 0; i < 10000; i++) count.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threads.add(new Thread(atomicIntegerTest::m, "thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("count: " + atomicIntegerTest.count);
    }



}

package com.peactor.concurrency.c_02_volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 多线程中volatile关键字测试，开启十个线程进行操作
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class VolatileTest {

    volatile int count = 0;

     void m() {
        for(int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threads.add(new Thread(volatileTest::m, "thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("count: " + volatileTest.count);
    }
}
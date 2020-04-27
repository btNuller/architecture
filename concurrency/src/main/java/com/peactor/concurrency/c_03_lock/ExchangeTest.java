package com.peactor.concurrency.c_03_lock;

import java.util.concurrent.Exchanger;

/**
 * @Description: 交换器
 * 执行 exchange()方法的时候，线程进入阻塞状态，等待需要交换的值,当第二个线程中的exchange()方法执行之后，便开始交换
 * 两个线程的场景可以用到，更多则不行
 * @Author: Ifan
 * date: 2020-04-27
 **/
public class ExchangeTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t2").start();


    }
}

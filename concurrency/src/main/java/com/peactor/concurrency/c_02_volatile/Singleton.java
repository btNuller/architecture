package com.peactor.concurrency.c_02_volatile;

/**
 * @Description: 单例模式
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class Singleton {

    private static volatile Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
    }

}
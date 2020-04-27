package com.peactor.concurrency.c_02_volatile;

import sun.misc.Unsafe;

/**
 * @Description: 测试Unsafe
 * @Author: Ifan
 * date: 2020-04-23
 **/
public class HelloUnsafe {

    static class M {
        private M() {}
        int i = 0;
    }

    public static void main(String[] args) {
        //无法new Unsafe类
//        unsafe = new Unsafe();
    }
}
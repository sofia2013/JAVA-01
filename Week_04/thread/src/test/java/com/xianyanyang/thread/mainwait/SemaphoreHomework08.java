package com.xianyanyang.thread.mainwait;

import com.xianyanyang.thread.mainwait.utils.SumUtils;

import java.util.concurrent.Semaphore;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class SemaphoreHomework08 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(0);
        new Thread(() -> {
            int result = SumUtils.sum();
            System.out.println("异步计算结果为：" + result);
            semaphore.release();
        }).start();
        semaphore.acquire();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}

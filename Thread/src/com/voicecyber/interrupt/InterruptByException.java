package com.voicecyber.interrupt;

import java.time.LocalDateTime;

import static java.lang.Thread.interrupted;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class InterruptByException implements Runnable {
    boolean flag=false;
    @Override
    public void run() {
        while (!flag) {
            System.out.println("当前线程执行时间：" + LocalDateTime.now() + Thread.currentThread().getName() );
            flag=Thread.currentThread().isInterrupted();
        }
        System.out.println("线程中断");
    }

}

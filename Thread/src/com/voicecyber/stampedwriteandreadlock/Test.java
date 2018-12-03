package com.voicecyber.stampedwriteandreadlock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        StampedLockService lockService = new StampedLockService("hello sean", new StampedLock());
        Thread thread = new Thread(() -> {
            while (true) {
                lockService.writeMsg();
            }
        });
        thread.setName("write  msg thread ");
        thread.start();

        for (int i = 0; i < 3; i++) {
            Thread thread1 = new Thread(() -> {
                while (true) {
                    lockService.readMsg();
                }
            });
            thread1.setName("read msg thread : " + i);
            thread1.start();
        }
    }
}

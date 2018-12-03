package com.voicecyber.stampedwriteandreadlock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class StampedLockService {
    private String msg;
    private StampedLock stampedLock;
    private int i=0;

    public StampedLockService(String msg, StampedLock stampedLock) {
        this.msg = msg;
        this.stampedLock = stampedLock;
    }

    void writeMsg() {
        long l = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName() + "start write");
        msg = "hello world" +i;
        stampedLock.unlockWrite(l);
        i++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void readMsg() {
        String readMsg = msg;
        long stmap = stampedLock.tryOptimisticRead();
        if (!stampedLock.validate(stmap)) {
            stmap = stampedLock.readLock();
            readMsg = msg;
            stampedLock.unlockRead(stmap);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "当前 Msg is :" + readMsg);

    }

}

package com.voicecyber.reentrantreadwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class ReadWriteService {
    private String context = null;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void read() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "获得写锁内容：" + context);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "获得读锁 开始写数据");
        context = "hello this is read lock ";
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}

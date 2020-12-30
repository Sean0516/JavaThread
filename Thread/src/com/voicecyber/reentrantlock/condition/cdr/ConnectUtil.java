package com.voicecyber.reentrantlock.condition.cdr;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ConnectUtil
 * @Author Sean
 * @Date 2020/12/21 15:50
 * @Version 1.0
 */
public class ConnectUtil {
    private Lock reentrantLock = new ReentrantLock();
    private Condition connectCondition = reentrantLock.newCondition();
    private Condition cdrCondition = reentrantLock.newCondition();

    public void awaitConnection() {
        reentrantLock.lock();
        try {
            System.out.println("connection await");
            connectCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void notifyConnection() {
        reentrantLock.lock();
        try {
            System.out.println("connection signal");
            connectCondition.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
    public void awaitCdr(){
        reentrantLock.lock();
        try {
            System.out.println("cdr await");
            cdrCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
    public void notifyCdr() {
        reentrantLock.lock();
        try {
            System.out.println("cdr signal");
            cdrCondition.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}

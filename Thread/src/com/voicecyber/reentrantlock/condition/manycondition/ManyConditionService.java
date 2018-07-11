package com.voicecyber.reentrantlock.condition.manycondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class ManyConditionService {
    private Lock reentrantLock= new ReentrantLock();
    private Condition conditionA=reentrantLock.newCondition();
    private Condition conditionB=reentrantLock.newCondition();

    public void awaitA(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() +"等待时间:" +System.currentTimeMillis());
        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
    public void anotifyA(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+"释放时间"+System.currentTimeMillis());
        try {
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         reentrantLock.unlock();
        }
    }
    public void awaitB(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() +"等待时间:" +System.currentTimeMillis());
        try {
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
    public void anotifyB(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+"释放时间"+System.currentTimeMillis());
        try {
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
}

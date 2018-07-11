package com.voicecyber.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class SimpleConditionService {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void await(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() +"等待时间:" +System.currentTimeMillis());
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void  anotify(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"释放时间"+System.currentTimeMillis());
        try {
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

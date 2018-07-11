package com.voicecyber.reentrantlock.customerandproducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class CommonMethod {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean flag=true;
    public void customer(){
        lock.lock();
        while (flag==false){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费者开始消费数据");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=false;
        condition.signalAll();
        lock.unlock();
    }
    public void producer(){
        lock.lock();
        while (flag==true){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"生产者开始生产数据");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        condition.signalAll();
        lock.unlock();
    }

}

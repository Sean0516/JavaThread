package com.voicecyber.semaphore.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/12/4
 *
 * @author Sean
 */
public class ListStringPool {
    private int poolSize=3;
    private int semaphorePermits=5;
    private List<String> strList=new ArrayList<>();
    private Semaphore semaphore=new Semaphore(semaphorePermits);
    private ReentrantLock reentrantLock=new ReentrantLock();
    private Condition condition=reentrantLock.newCondition();

    public ListStringPool() {
        for (int i = 0; i <poolSize ; i++) {
            strList.add("Sean " +i);
        }
    }
    public String getPoolValue(){
        String str="";
        try {
            semaphore.acquire();
            reentrantLock.lock();
            while (strList.size()==0){
                condition.await();
            }
            str=strList.remove(0);
            reentrantLock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }
    public void putValueToPool(String value){
        reentrantLock.lock();
        strList.add(value);
        condition.signalAll();
        reentrantLock.unlock();
        semaphore.release();
    }
}

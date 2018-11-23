package com.voicecyber.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class GetNum implements Runnable{
    private  int num;
    private Lock lock=new ReentrantLock(true);

    public GetNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        for (int i = 0; i <5 ; i++) {
            lock.lock();
            num++;
            System.out.println(Thread.currentThread().getName()+"num:" +num);
            lock.unlock();
        }

    }
}

package com.voicecyber.blockqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Sean on 2018/12/19
 *
 * @author Sean
 */
public class SynchronousGetThread extends Thread {
    private SynchronousQueue<String> synchronousQueue;

    public SynchronousGetThread(SynchronousQueue<String> synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                String take = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() +"---get Value form Queue is " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

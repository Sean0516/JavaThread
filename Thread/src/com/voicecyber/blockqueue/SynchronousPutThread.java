package com.voicecyber.blockqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Sean on 2018/12/19
 *
 * @author Sean
 */
public class SynchronousPutThread extends Thread {
    private SynchronousQueue<String> synchronousQueue;

    public SynchronousPutThread(SynchronousQueue<String> synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                synchronousQueue.put("Hello world" + i);
                System.out.println(Thread.currentThread().getName() + "put value to queue ----Hello world" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue=new SynchronousQueue<>();
        SynchronousPutThread synchronousPutThread=new SynchronousPutThread(synchronousQueue);
        synchronousPutThread.setName("PutValueThread");
        SynchronousGetThread synchronousGetThread=new SynchronousGetThread(synchronousQueue);
        synchronousGetThread.setName("GetValueThread");
        synchronousPutThread.start();
        synchronousGetThread.start();
    }
}

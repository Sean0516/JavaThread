package com.voicecyber.waitandnotify;

/**
 * Created by Sean on 2018/7/4
 *
 * @author Sean
 */
public class Producer implements Runnable {
    private Method method;
    public Producer(Method method){
        this.method=method;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            method.produce();
        }
    }
}

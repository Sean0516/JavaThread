package com.voicecyber.interrupt;

import static java.lang.Thread.interrupted;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class InterruptByReturn extends Thread{
    @Override
    public void run() {
        while (true){
            if (isInterrupted()){
                System.out.println("线程停止");
                return;
            }
            System.out.println("currentTime;"+System.currentTimeMillis());
        }
    }
}

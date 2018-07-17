package com.voicecyber.cyclicbarrier;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class CyclicBarrierAction implements Runnable{

    @Override
    public void run() {
        System.out.println("CyclicBarrierAction 当所有线程都到达屏障区时，我先执行");
    }
}

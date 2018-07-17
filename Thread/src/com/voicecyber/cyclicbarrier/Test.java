package com.voicecyber.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(4,new CyclicBarrierAction());
        CyclicBarrierThread cyclicBarrierThread=new CyclicBarrierThread(cyclicBarrier);
        for (int i = 0; i <3 ; i++) {
            new Thread(cyclicBarrierThread).start();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("main 主线程");
    }
}

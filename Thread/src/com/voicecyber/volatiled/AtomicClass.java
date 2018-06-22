package com.voicecyber.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class AtomicClass implements Runnable {
    private AtomicInteger count=new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(count.incrementAndGet());

        }

    }
}

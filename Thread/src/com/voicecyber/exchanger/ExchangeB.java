package com.voicecyber.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class ExchangeB implements Runnable {
    private Exchanger<String> exchanger;

    public ExchangeB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String B="Exchange B";
        try {
            System.out.println(Thread.currentThread().getName()+ "获得线程A的数据是 ："+exchanger.exchange(B));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.voicecyber.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class ExchangeA implements Runnable {
    private Exchanger<String> exchanger;

    public ExchangeA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String A="ExchangeA";
        try {
            System.out.println(Thread.currentThread().getName()+"A "+A);
            String exchange = exchanger.exchange(A);
            System.out.println("from "+exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

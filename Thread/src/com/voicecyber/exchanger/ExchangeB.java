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
        String B="ExchangeB";
        try {
            String A=exchanger.exchange(B);
            System.out.println("A 的数据是"+A +"____B的数据是"+B);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

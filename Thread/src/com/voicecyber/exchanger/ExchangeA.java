package com.voicecyber.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
        String A="Exchange A";
        try {
            System.out.println(Thread.currentThread().getName()+"获得线程B 的数据 ： "+exchanger.exchange(A,5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

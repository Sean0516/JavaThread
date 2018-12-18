package com.voicecyber.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<>();
        ExchangeA exchangeA=new ExchangeA(exchanger);
        ExchangeB exchangeB=new ExchangeB(exchanger);
        Thread threadA=new Thread(exchangeA);
        threadA.setName("Thread A");
        Thread threadB=new Thread(exchangeB);
        threadB.setName("Thread B");
        threadA.start();
        threadB.start();
    }
}

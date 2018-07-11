package com.voicecyber.reentrantlock.condition.manycondition;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class ThreadB implements Runnable{
    private ManyConditionService service;

    public ThreadB(ManyConditionService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}

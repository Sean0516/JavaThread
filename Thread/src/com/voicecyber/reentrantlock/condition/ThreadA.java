package com.voicecyber.reentrantlock.condition;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class ThreadA implements Runnable {
    private SimpleConditionService simpleConditionService;

    public ThreadA(SimpleConditionService simpleConditionService) {
        this.simpleConditionService = simpleConditionService;
    }

    @Override
    public void run() {
        simpleConditionService.await();
    }
}

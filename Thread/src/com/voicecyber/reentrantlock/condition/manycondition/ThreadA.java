package com.voicecyber.reentrantlock.condition.manycondition;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class ThreadA implements Runnable{
   private ManyConditionService conditionService;

    public ThreadA(ManyConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run() {
        conditionService.awaitA();
    }
}

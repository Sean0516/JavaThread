package com.voicecyber.reentrantlock.customerandproducer;

/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class Producer extends Thread {
    private CommonMethod commonMethod;

    public Producer(CommonMethod commonMethod) {
        this.commonMethod = commonMethod;
    }

    @Override
    public void run() {
        while (true){
            commonMethod.producer();
        }
    }
}

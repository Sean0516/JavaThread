package com.voicecyber.reentrantlock.customerandproducer;

/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class Customer extends Thread {
    private CommonMethod commonMethod;

    public Customer(CommonMethod commonMethod) {
        this.commonMethod = commonMethod;
    }

    @Override
    public void run() {
        while (true){
            commonMethod.customer();
        }
    }
}

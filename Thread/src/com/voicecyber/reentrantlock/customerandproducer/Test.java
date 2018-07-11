package com.voicecyber.reentrantlock.customerandproducer;



/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        CommonMethod commonMethod=new CommonMethod();
        Customer customer=new Customer(commonMethod);
        Producer producer=new Producer(commonMethod);
        customer.setName("customer");
        producer.setName("producer");
        customer.start();
        producer.start();
    }
}

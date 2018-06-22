package com.voicecyber.volatiled;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Volatile aVolatile = new Volatile();
        aVolatile.setName("线程1");
        Volatile aVolatile2=new Volatile();
        aVolatile2.setName("线程2");
        aVolatile.start();
        aVolatile2.start();
        System.out.println(aVolatile.getNum()+"_______");
        Thread.sleep(2000);
        aVolatile.setNum(110);
        aVolatile2.setNum(110);
    }

}

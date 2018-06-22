package com.voicecyber.interrupt;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
/**
 *         InterruptByReturn interruptByReturn=new InterruptByReturn();
 interruptByReturn.start();
 try {
 Thread.sleep(1000*1);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 interruptByReturn.interrupt();
 */
        InterruptByException interruptByException=new InterruptByException();
        Thread thread=new Thread(interruptByException);
        thread.setName("线程1");
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}

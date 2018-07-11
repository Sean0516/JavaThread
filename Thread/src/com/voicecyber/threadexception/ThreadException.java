package com.voicecyber.threadexception;

/**
 * Created by Sean on 2018/7/11
 *
 * @author Sean
 */
public class ThreadException  implements Runnable{
    @Override
    public void run() {
        System.out.println("这是一个异常线程，下面进行异常抛出");
        throw new NullPointerException("抛出一个空指针异常");

    }
}
